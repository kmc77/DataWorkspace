<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>DB 베이직</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <style>
    #com { color: blue; } /* 파란색 텍스트를 위한 CSS 클래스 */
  legend {
    text-align: center;
  }
</style>
</head>
<body>
  <div class="container">
    <form id="insert_form">
     <fieldset>
      <legend>데이터 추가/삭제/수정</legend>
       <table class="table">
        <tr>
        	<th><label>상품명</label></th>
        	<td><input type="text" name="name" class="form-control" id="name" required></td>
        </tr>
        <tr>
        	<th><label>가격</label></th>
        	<td><input type="text" name="price" class="form-control" id="price" pattern="[0-9]+"></td>
        </tr>
        <tr>
        	<th><label>메이커</label></th>
        	<td><input type="text" name="maker" class="form-control" id="maker" required></td>
        </tr>
       <tr>
       <td colspan="2">
        <button type="submit" class="btn btn-primary btn-block">추가</button>
       </td>
       </tr>
       </table>
     </fieldset>
     </form>
     </div>
    <script>
    		// get방식 전송시 데이터 가져오기, post방식 전송시 삽입 또는 삭제 또는 수정과 데이터 가져오기
    	function selectData(method, label) {
    		$("#result").remove();
    		let senddata = "";
    		if(label == '추가' || label == '수정완료'){
    			senddata = $("#insert_form").serialize() + "&label=" + label;
    		} else if (label == '삭제') {
    			senddata = {id : $('input:hidden').val(), label : label};
    		}
    		// Ajax를 수행합니다.
    		$.ajax({
    			type: method, //"get", "post" - 전송방식
    	          url: '${pageContext.request.contextPath}/product2', // 수정
    	          data: senddata,	// 보낼 데이터
    	          dataType: 'json',
    	          success: function(rdata) {
    	            if(rdata.length>0){
                        let output = '<div id="result"><table  class="table">'
                       + '<thead><tr><th>아이디</th><th>상품명</th><th>가격</th><th>메이커</th><th>수정</th><th>삭제</th></tr></thead>'
                       + '<tbody>';
             	       $(rdata).each(function (index, item) { 
                          output += '<tr>';
                          output += '    <td>' + item.id + '</td>';
                          output += '    <td>' + item.name + '</td>';
                         // output += '    <td>' + item.price.toLocaleString() + '</td>';
                         output += '    <td>' + item.price + '</td>';
                          output += '    <td>' + item.maker + '</td>';
                          output += '    <td><button type=button class="btn btn-warning btn-sm">수정</button></td>';
                          output += '    <td><button type=button class="btn btn-danger btn-sm">삭제</button></td>'; 
                          output += '</tr>';
                        });//each end
                      output += '</tbody></table></div>';
                        $('.container').append(output);
                        $('input').val('');
    			} else {
    				$('.container').append('<div id="result">데이터가 존재하지 않습니다.</div>');
    			}
    		}, //success end
    		error: function(request, status, error) {
                $(".container").append("<div id='result'>코드: "
                  + request.status + "<br>"
                  + "받은 데이터: " + request.responseText + "<br>"
                  + "에러 상태: " + status + "<br>"
                  + "에러 메시지: " + error + "</div>");
              } // error end
            }); // ajax end
        } // function getData() end
        
         //초기 화면에 데이터를 표시합니다.
         selectData('get');
        
        
        //데이터를 추가합니다.
        $('#insert_form').submit(function (event) {
        	
        	//기본 이벤트를 제거합니다.
        	event.preventDefault();
        	
        	const label = $(this).find('button').text();
        	selectData('post');
        	
        	if(label == '수정완료') {
        		$('button:submit').text('추가').removeClass('btn-success').addClass('btn-primary');
        		$('button.btn-danger').prop("disabled", false);//수정완료 버튼을 클릭하면 삭제 버튼 사용가능합니다.
        	}	
        }); //submit end
        
        //수정 버튼 클릭시 폼 화면의 input에 각각의 데이터가 나타납니다.
        //$(".btn.btn-warning").on('click', function() { //작동 안합니다.
        $("body").on('click', '.btn.btn-warning', function() {
        	
        	//클릭한 수정 버튼의 tr 객체를 구합니다.
        	const tr = $(this).parent().parent()
        	
        	//tr객체의 첫번째 자식 td의 텍스트 노드값을 구합니다.
        	const id = tr.find('td:nth-child(1)').text();
        	
        	const name = tr.find('td:nth-child(2)').text();
        	const price = tr.find('td:nth-child(3)').text();
        	const maker = tr.find('td:nth-child(4)').text();
        
        	 // ID name 요소의 값을 설정합니다.
            $('#name').val(name);
            
            // 가격에서 쉼표를 제거하고, 가격 입력 요소의 값을 설정합니다.
            $('#price').val(price.replace(/,/g , "")); //가격에서 콤마를 없애줍니다.
            
            // 메이커 입력 요소의 값을 설정합니다.
            $('#maker').val(maker);
            
            //추가 버튼이 수정완료버튼으로 label과 색상을 바꿉니다.
            $('button:submit').text('수정완료').removeClass('btn-primary').addClass('btn-success');
            
            $('input:hidden').remove(); //수정 버튼을 여러번 누른 경우 아래의 문장 수행으로  input 태그가 여러 개 생길 수 있어 제거 합니다.
            
            //id값을 폼안의 버튼 뒤에 보이지 않게 추가합니다
            $('button:submit').after("<input type='hidden' name='id' value='" + id + "'>");
            
            //수정버튼 클릭 후 수정완료 버튼을 클릭 전까지는 삭제 버튼 비활성화로 만듭니다.
            $('button.btn-danger').prop("disabled", true);
        })//$("body").on('click', '.btn.btn-warning', function(){ end
        	
        
        //삭제 클릭시
        $("body").on('click', '.btn.btn-danger', function(){
        	
        	if(confirm('정말 삭제하시겠습니까?')){
        		const tr = $(this).parent().parent()
        		const id = tr.find('td:nth-child(1)').text();
        		 $('button:submit').after("<input type='hidden' name='id' value='" + id + "'>");
        		 selectData('post', "삭제");
        	}
        	})
        	
    </script> 
</body>
</html>
