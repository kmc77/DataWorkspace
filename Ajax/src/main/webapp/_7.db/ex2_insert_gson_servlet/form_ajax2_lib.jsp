<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>DB 베이직</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <style>
    #com { color: blue; } /* 파란색 텍스트를 위한 CSS 클래스 */
  </style>
</head>
<body>
  <div class="container">
    <form id="insert_form">
     <fieldset>
      <legend>데이터 추가</legend>
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
    		// 데이터 가져오기 또는 삽입을 위한 함수
    	function selectData(m) {
    		$("#result").remove();
    		const senddata = $("#insert_form").serialize();
    		// Ajax를 수행합니다.
    		$.ajax({
    			type: m, //"get", "post" - 전송방식
    	          url: '${pageContext.request.contextPath}/product', // 수정
    	          data: senddata,						// 추가
    	          dataType: 'json',
    	          success: function(rdata) {
    	            console.log("성공", rdata);
    	            if(rdata.length>0){
                        let output = '<div id="result"><table  class="table">'
                       + '<thead><tr><th>아이디</th><th>상품명</th><th>가격</th><th>메이커</th></tr></thead>'
                       + '<tbody>';
             	       $(rdata).each(function (index, item) { 
                          output += '<tr>';
                          output += '    <td>' + item.id + '</td>';
                          output += '    <td>' + item.name + '</td>';
                         // output += '    <td>' + item.price.toLocaleString() + '</td>';
                         output += '    <td>' + item.price + '</td>';
                          output += '    <td>' + item.maker + '</td>';
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
        	
        	selectData('post');
        }); //submit end
    </script> 
</body>
</html>
