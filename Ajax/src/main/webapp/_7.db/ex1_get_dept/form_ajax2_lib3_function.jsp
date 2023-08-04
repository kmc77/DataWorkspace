<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>ajax 실행하기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <style>
    td:nth-child(3n) { text-align: right; }
    #com { color: blue; } /* CSS class for blue text */
  </style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
<body>
  <div class="container">
  </div>
  <script>
    function getData() {
        $.ajax({
          type: "post",
          url: "${pageContext.request.contextPath}/dept_lib",
          dataType: "json",
          success: function(rdata) {
            console.log("성공", rdata);
            $("button+div").remove();
            if (rdata.length > 0) {
              let output = '<div id="result"><table class="table">'
                + '<thead><tr><th>부서번호</th><th>부서명</th><th>지역</th></tr></thead>'
                + '<tbody>';
              $(rdata).each(function (index, item) {
                output += '<tr>';
                output += ' <td>' + item.deptno + '</td>';
                output += ' <td>' + item.dname + '</td>';
                output += ' <td>' + item.loc + '</td>';
                output += '</tr>';
              });
              output += '</tbody></table></div>';
              $('.container').append(output);
            } else {
              $('.container').append('<div>데이터가 존재하지 않습니다.</div>');
            }
          },
          error: function(request, status, error) {
            $(".container").append("<div id='error'>코드: "
              + request.status + "<br>"
              + "받은 데이터: " + request.responseText + "<br>"
              + "에러 상태: " + status + "<br>"
              + "에러 메시지: " + error + "</div>");
          }//error end
          });//ajax end
    }//function getData() end
    
    getData();
  </script>
</head>
</body>
</html>
