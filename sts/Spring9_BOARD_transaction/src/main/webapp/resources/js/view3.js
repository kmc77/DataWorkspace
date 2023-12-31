$(function() {
$("#comment table").hide();
let page = 1;
const count = parseInt($("#count").text());

if (count !== 0) {
    getList(1);
} else {
    $("#message").text("등록된 댓글이 없습니다.");
}

let num = 0;
let url = '';
let date = {};

function getList(currentPage) { // 현재 선택한 댓글 정렬방식을 저장합니다. 1=>등록순, 2=>최신순
    $.ajax({
        type: "post",
        url: "../comment/list",
        data: {
            "comment_board_num": $("#comment_board_num").val(),
            state: option
        },
        dataType: "json",
        success: function(rdata) {
            $('#count').text(rdata.listcount);

            if (rdata.listcount > 0) {
                $("#comment table").show();
                $("#comment tbody").empty();

                $(rdata.list).each(function() {
                    let output = '';
                    let img = '';

                    if ($("#loginid").val() === this.id) {
                        img =
                            "<img src='../resources/image/pencil2.png' width='15px' class='update'>" +
                            "<img src='../resources/image/delete.png' width='15px' class='remove'>" +
                            "<input type='hidden' value='" + this.num + "' >";
                    }

                    output += "<tr><td>" + this.id + "</td>";
                    output += "<td>" + $("<div>").text(this.content).html() + "</td>";
                    output += "<td>" + this.reg_date.substring(0, 19) + img + "</td></tr>";

                    $("#comment tbody").append(output);
                });

                if (rdata.listcount > rdata.list.length) {
                    $("#message").text("더보기");
                } else {
                    $("#message").text("");
                }
            } else {
                $("#message").text("등록된 댓글이 없습니다.");
                $("#comment table").hide();
            }
        },
        error: function(xhr, status, error){
        	console.log(xhr.responseText); // 에러 내용 콘솔 출력
    	}
    });
 }
 
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

});