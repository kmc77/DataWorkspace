function go(page) {
    const limit = $('#viewcount').val();
    const data = { limit: limit, state: "ajax", page: page };
    ajax(data);
}

//총 2페이지 페이징 처리된 경우
//이전 1 2 다음
//현재 페이지가 1페이지인 경우 아래와 같은 페이징 코드가 필요
//<li class="page-item"><a class="page-link gray">이전&nbsp;</a></li>
//<li class="page-item active"><a class="page-link">1</a></li>
//<li class="page-item"><a class="page-link" href="javascript:go(2)">2</a></li>
//<li class="page-item"><a class="page-link" href="javascript:go(2)">다음&nbsp;</a></li>

//현재 페이지가 2페이지인 경우 아래와 같은 페이징 코드가 필요
//<li class="page-item"><a class="page-link" href="javascript:go(1)">이전&nbsp;</a></li>
//<li class="page-item"><a class="page-link" href="javascript:go(1)">1</a></li>
//<li class="page-item active"><a class="page-link">2</a></li>
//<li class="page-item"><a class="page-link gray">다음&nbsp;</a></li>

function setPaging(href, digit) {
    let active = "";
    let gray = "";
    if (href === "") {
        if (isNaN(digit)) {
            gray = "gray";
        } else {
            active = "active";
        }
    }
    let output = `<li class="page-item ${active}">`;
    //let output = '<a class="page-link " + gray + "'" + href + ">" + digit + "</a></li>";
    let anchor = `<a class="page-link ${gray}" ${href}>${digit}</a></li>`;
    output += anchor;
    return output;
}

function ajax(sdata) {
    console.log(sdata);

    $.ajax({
        type: "POST",
        data: sdata,
        url: "BoardList.bo",
        dataType: "json",
        cache: false,
        success: function(data) {
            $("#viewcount").val(data.limit);
            $("thead").find("span").text("글 개수: " + data.listcount);

            if (data.listcount > 0) { // 조회된 글이 0개 이상인 경우
                $("tbody").remove();
                let num = data.listcount - (data.page - 1) * data.limit;
                console.log(num);
                let output = "<tbody>";
                $(data.boardlist).each(function(index, item) {
                    output += '<tr><td>' + (num--) + '</td>';
                    const blank_count = item.board_RE_LEV * 2 + 1;
                    let blank = ' ';
                    for (let i = 0; i < blank_count; i++) {
                        blank += '  ';
                    }

                    let img = "";
                    if (item.board_RE_LEV > 0) {
                        img = "<img src='image/line.gif'>";
                    }

                    let subject = item.board_SUBJECT;
                    if (subject.length >= 20) {
                        subject = subject.substr(0, 20) + "..."; //0부터 20개 부분 문자열 추출
                    }

                    output += "<td><div>" + blank + img;
                    output += ' <a href="BoardDetailAction.bo?num=' + item.board_num + '">';
                    output += subject.replace(/</g, '<').replace(/>/g, '>')
                        + '</a>[' + item.cnt + ']</div></td>'
                    output += '<td><div>' + item.board_name + '</div></td>'
                    output += '<td><div>' + item.board_date + '</div></td>'
                    output += '<td><div>' + item.board_readcount
                        + '</div></td></tr>'

                })
                output += "</tbody>";
                $(".table").append(output); // 테이블 완성

                $(".pagination").empty(); // 페이징 처리 영역 내용 제거
                output = "";

                let digit = '&nbsp;이전&nbsp;';
                let href = "";
                if (data.page > 1) {
                    href = 'href=javascript:go(' + (data.page - 1) + ')';
                }
                output += setPaging(href, digit);

                for (let i = data.startpage; i <= data.endpage; i++) {
                    digit = i;
                    href = "";
                    if (i != data.page) {
                        href = 'href=javascript:go(' + i + ')';
                    }
                    output += setPaging(href, digit);
                }

                digit = '&nbsp;다음&nbsp;';
                href = "";
                if (data.page < data.maxpage) {
                    href = 'href=javascript:go(' + (data.page + 1) + ')';
                }
                output += setPaging(href, digit);

                $('.pagination').append(output)
            } // if (data.listcount > 0) end
            
        }, // success end
        error : function() {
			console.log('에러')
		}
    }) // ajax end
} // function ajax end

$(function() {
    $("button").click(function() {
        location.href = "write";
    });

    $("#viewcount").change(function() {
        go(1); // 페이지를 1로 설정하고 조회 수를 변경합니다.
    }); // 변경 이벤트 종료
});
