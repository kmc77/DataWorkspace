$(function() {
	$("#comment table").hide(); //1
	let page =1; // 더보기에서 보여줄 페이지를 기억할 변수
	const count = parseInt($("#count").text());
	if (count !=0){ //댓글 갯수가 0 이 아니면
		getList(1); // 첫페이지 댓글을 구해옵니다(한 페이지에 3개씩 가져옵니다)
		}else { // 댓글이 없는 경우
			$("#message").text("등록된 댓글이 없습니다.")
		}
		
		let num = 0;
		let url = '';
		let data= {};
		
		function getList(currentPage) {
		$.ajax({
					type : "post",
					url  : "../comment/list",
					data : {
						"board_num" : $("#board_num").val(),
						"page" : currentPage
						},
						dataType : "json",
						success : function(rdata) {
							$("#count").text(rdata.listcount);
							if(rdata.listcount >0) {
								$("#comment table").show(); //문서가 로딩될 때 hide()했던 부분을 보이게 합니다.
								$("#comment tbody").empty();
								
								$(rdata.list).each(function() {
									let output = '';
									let img = '';
									if ($("#loginid").val()==this.id) {
										img = "<img src ='../resources/image/pencil2.png' width='15px' class='update'>"
											+ "<img src = '../resources/image/delete.png' width = '15px' class='remove'>"
											+ "<input type='hidden' value='"  + this.num + "' >";
										}
										output += "<tr><td>" + this.id + "</td>";
										
										//XSS(Cross-Sites-Scripting): 권한이 없는 사용자가 웹 사이트에 스크립트를 삽입하는 공격기법
										// 이것을 방지하기 위한 방법으로 2번처럼 <td></td> 영역을 만든 뒤 3번에서 text()안에
										output += "<td></td>"; //2
										//2번과 3번을 이용하지 않고 4번을 이용하면 스크립트가 있는 경우 스크립트 실행됩니다.
										//output += "<td>" + this.content + "</td>"; //4
										output += "<td>" + this.reg_date.substring(0,19) + img + "</td></tr>";
										$("#comment tbody").append(output);
										
										//append 한 마지막 r의 2번째 자식 td를 찾아 text()메서드로 content를 넣습니다.
										$("#comment tbody tr:last").find("td:nth-child(2)").text(this.content); //3
										console.log(output);
										
										}); //each end
										
										if(rdata.listcount > rdata.list.length) { // 전체 댓글 개수 > 현재까지 보여준 댓글 갯수
											$("#message").text("더보기")
										}else { 
											$("#message").text("")
										}
										
										}else {
										$("#message").text("등록된 댓글이 없습니다.")
										$("#comment table").hide()//1
										}
									}
			}); //ajax end
		} //function end
		
		// 글자수 제한 이벤트
	$("#content").on('input', function() {
	 	let content = $(this).val();
	 	let length = content.length;

	 	if (length > 50) {
	     	length = 50;
	     	content = content.substring(0, length);
	     	$(this).val(content);
	 	}

	 	$(".float-left").text(length + "/50")
	});
	
	//더보기를 클릭하면 page 내용이 추가로 보여집니다.
	$("#message").click(function() {
		getList(++page);
		}); //click end
	
	//등록 또는 수정완료 버튼을 클릭한 경우
	// 버튼의 라벨이 '등록' 인 경우는 댓글을 추가하는 경우
	// 버튼의 라벨이 '수정완료' 인 경우는 댓글을 수정하는 경우
	$("#write").click(function() {
		const content = $("#content").val().trim();
		if(!content){ 
			alert('내용을 입력하세요')
			return false;
		}
		const buttonText = $("#write").text(); //버튼의 라벨로 add할지 update 할지 결정
		
		$(".float-left").text('총 50자 까지 가능합니다.');
		
		if(buttonText=="등록") { // 댓글을 추가하는 경우
			url = "../comment/add";
			data = {
				"content": content,
				"id" : $("#loginid").val(),
				"board_num" : $("#board_num").val()
				};
				
				}else { //댓글을 수정하는 경우
					url ="../comment/update";
					data = {
						"num" : num,
						"content" : content
						};
						$("#write").text("등록"); // 다시 등록으로 변경
						$("#comment .cancel").remove();// 취소 버튼 삭제
				}
				
				$.ajax({
					type : "post",
					url  : url,
					data : data,
					success : function(result) {
						$("#content").val('');
						if(result == 1) {
						// page = 1
						getList(page); //등록, 수정완료 후 해당 페이지 보여줍니다.
					} //if
				}//success
			}) // ajax end
		})// $("write") end
		
		// pencil2.png를 클릭하는 경우(수정)
	$("#comment").on('click', '.update', function() {
		const before = $(this).parent().prev().text(); // 선택한 내용을 가져옵니다.
		$("#content").focus().val(before); // textarea에 수정전 내용을 보여줍니다.
		num = $(this).next().next().val(); // 수정할 댓글번호를 저장합니다.
		$("#write").text("수정완료"); // 등록버튼의 라벨을 '수정완료'로 변경합니다.
		
		//이미 취소 버튼이 만들어진 상태에서 또 수정을 클릭하면 취소가 계속 추가됩니다.
		if(!$("#write").prev().is(".cancel"))
		  $("#write").before('<button class="btn btn-danger float-right cancel">취소</button>'); 
		
		//모든 행의 배경색을 'white'로 지정합니다.
		$("#comment tr").css('background-color', 'white');
		
		//선택한 행의 배경색을 'lightgray'로 지정합니다.
		$(this).parent().parent().css('background-color', 'lightgray');// 수정할 행의  배경색을 변경합니다.
		$(".remove").prop("disabled",true);// [수정완료][취소] 중에는 삭제를 클릭할 수 없도록 합니다.
	})
			
});