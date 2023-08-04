<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Using JSON</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
    td:nth-child(3n) { text-align: right; }
    /* Add the following CSS to style the error message in green */
    #error {
      color: green;
    }
  </style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script>
    /*
    1. $.ajax(object) 함수:
      - url: 요청 전송 URL,
      - type: 전송 방식 (get (기본값) 또는 post),
      - data: 전송할 데이터,
      - cache: false 설정은 브라우저의 캐시를 사용하지 않고 매번 최신 데이터를 서버에서 가져오도록 합니다.
      - dataType: 반환 데이터 유형 (Ajax 성공 후 반환되는 데이터 유형을 정의합니다. "json", "xml", "html" 등),
      - success: HTTP 요청이 성공할 경우 실행될 함수를 정의합니다. (이벤트 핸들러),
      - error: HTTP 요청이 실패할 경우 실행될 함수를 정의합니다.,
      - complete: 요청이 실패하거나 성공하더라도 실행될 함수를 정의합니다.
    */

    $(function() {
      $("button").click(function() { // 버튼 클릭 시
        // 이전 데이터 요소 삭제
        $("table").remove(); // 테이블 요소 삭제
        $(".container div").remove(); // div 요소 삭제

        $.ajax({
        	url : "item_error.json",
          //url: "item.json", // 요청 전송 URL
          dataType: "json", // 반환 데이터 유형 (Ajax 성공 후 반환되는 데이터의 유형을 정의합니다)
          cache: false, // 캐시 비활성화
          success: function(rdata) { // HTTP 요청 성공 시 실행되는 함수 (이벤트 핸들러)
            // rdata는 서버에서 전송된 데이터입니다.
            if (rdata.length > 0) {
              let output = "<table class='table'><thead><tr><td>id</td><td>name</td>"
                + "<td>price</td><td>description</td></tr></thead><tbody>";

              $(rdata).each(function(index, item) {
                output += "<tr><td>" + this.id + "</td>"
                  + "<td>" + this.name + "</td>"
                  + "<td>" + this.price + "</td>"
                  + "<td>" + this.description + "</td></tr>";
              });

              output += "</tbody></table>";
              $(".container").append(output); // 테이블을 컨테이너에 추가합니다.
            } else {
              $("button").after("<div>요청한 데이터가 없습니다.</div>");
            }
          },
          error: function(request, status, error) { // HTTP 요청 실패 시 실행되는 함수
        	   $(".container").append("<div id='error'>code:"
        	            + request.status + "<br>"
        	            + "받은 데이터:" + request.responseText + "<br>"
        	            + "error status : " + status + "<br>"
        	            + "error 메시지: " + error + "</div>");
          },
          complete: function() { // 요청이 실패하거나 성공하더라도 실행되는 함수
            $(".container").append("<div id='com'>Ajax가 완료되었습니다.</div>");
          	console.log('ajax() - complete')
          }
        }); // ajax 종료
        
        console.log('ajax() 뒤')
      }); // click 종료
    });
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-info">JSON 데이터 불러오기</button>
  </div>
</body>
</html>
