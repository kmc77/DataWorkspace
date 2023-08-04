<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>CSV 형식의 데이터 가져오기</title>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script>
    $(function() {
      $("button").click(function() { // 버튼이 클릭되었을 때
        $.get("data.csv", function(input) { // data.csv 파일로부터 데이터를 가져옴
          console.log(input); // 데이터를 콘솔에 출력

          // 입력된 데이터를 줄 단위로 분할
          const inputs = input.split('\n');

          let output = "<table class='table'><tbody><tr><th>이름</th><th>지역</th>"
          + "<th>나이</th></tr>";


          for (let i = 0; i < inputs.length; i++) {
            output += "<tr>"; // 각 줄마다 새로운 행 생성

            // 쉼표를 기준으로 데이터 분할
            const result = inputs[i].split(',');

            for (let j = 0; j < result.length; j++) {
              output += "<td>" + result[j].trim() + "</td>"; // 각 값을 테이블 셀로 추가
            } // for j end

            output += "</tr>"; // 행 닫기
          } // for i end

          output += "</tbody></table>"; // 테이블 본문 종료 // 테이블 닫기
          $("div.container").html(output); // "pre" 요소를 테이블로 대체
        }); // get end
      }); // click end
    }); // ready end
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-primary">데이터 가져오기</button>
    <!-- <pre>Before change</pre> "pre" 요소는 테이블로 대체됩니다. -->
  </div>
</body>
</html>
