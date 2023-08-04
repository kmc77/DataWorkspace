<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Using JSON</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <style>
    td:nth-child(3n) { text-align: right; }
    #com { color: blue; } /* CSS class for blue text */
  </style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script>
   
    $(function() {
      $("button").click(function() { // 버튼 클릭 시
        // 이전 데이터 요소 삭제
        $(".container div").remove(); // div 요소 삭제

        $.ajax({
          url: "${pageContext.request.contextPath}/get_name_lib", // 요청 전송 URL
          dataType: "json", // 반환 데이터 유형 (Ajax 성공 후 반환되는 데이터 유형을 정의)
          cache: false, // 캐시 비활성화
          success: function(rdata) { // HTTP 요청 성공 시 실행되는 함수 (이벤트 핸들러)
            // rdata는 서버에서 보내진 데이터입니다.
            $("body .container").append("<div>서버에서 검색한 데이터는 <span style='color:red'>" + rdata.name + "</span>입니다.</div>");
          },
          error: function(request, status, error) { // HTTP 요청 실패 시 실행되는 함수
            $(".container").append("<div id='error'>코드:"
              + request.status + "<br>"
              + "받은 데이터:" + request.responseText + "<br>"
              + "에러 상태 : " + status + "<br>"
              + "에러 메시지: " + error + "</div>");
          },
          complete: function() { // 요청 실패 또는 성공 여부와 상관없이 실행되는 함수
        	  $("body .container").append("<div id='com'>에이잭스가 완료되었습니다.</div>");
          }
        }); // Ajax 종료
      }); // 클릭 이벤트 끝
    });
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-info">JSON 데이터를 서버로 부터 불러옵니다.</button>
  </div>
</body>
</html>
