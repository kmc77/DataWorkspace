<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 사용하기</title>
  <style>
    td:nth-child(3n) { text-align: right; }
  </style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script>
  /*
  1. JSON은 JavaScript Object Notation의 약어로, XML 데이터를 대체하는데 사용됩니다.
  2. JSON은 key와 value 쌍으로 이루어진 구조입니다.
  3. 배열을 사용할 때에는 중괄호({ })를 대괄호([ ]) 내부에 사용하여 결합합니다.
  4. jQuery는 JSON으로 표현된 데이터를 파일에 저장하고 필요할 때 로드하는 $.getJSON() 메서드를 제공합니다.
  
  5. 서버로부터 get 타입의 요청을 하고, JSON 형식으로 응답을 받기 위해
  $.getJSON() 메서드의 첫 번째 매개변수로 서버의 URL 주소를 지정합니다.
  (1) $.getJSON() 메서드의 첫 번째 매개변수로 서버의 URL 주소를 지정합니다.
  (2) 서버로의 요청이 성공적으로 완료되면, 두 번째 매개변수에 기술한 콜백 함수가 호출됩니다.
  형식) function(data, textStatus)
  ① 콜백 함수의 첫 번째 매개변수인 data는 서버로부터 반환된 JSON 객체 형식의 데이터입니다.
  ② 두 번째 매개변수인 textStatus는 성공적이면 문자열 "success"가 전달됩니다.
  
  (3) 자바스크립트의 JSON 객체는 JSON 데이터를 자바스크립트 객체로 변환하거나
  자바스크립트 객체를 문자열로 변환하는 기능을 제공합니다.
  ① JSON.stringify() 메서드: 자바스크립트 객체를 JSON 형식의 문자열로 변환합니다.
  이를 통해 브라우저에서 자바스크립트 객체를 다른 응용 프로그램으로 전달할 수 있습니다.
  ② JSON.parse() 메서드: JSON 데이터를 브라우저가 사용할 수 있는 자바스크립트 객체로 변환합니다.
  */
    $(function() {
      $("button").click(function() { // 버튼이 클릭되었을 때
        $.getJSON("item.json", function(data, textStatus) { // textStatus에는 item.json의 내용이 담겨있습니다.
          console.log("data=" + data);
          console.log("textStatus=" + textStatus);
          console.log("JSON.stringify(data)=" + JSON.stringify(data));
          $("table").remove();
          
          if (data.length > 0) {
            let output = "<table class=table><thead><tr><td>id</td><td>name</td>"
              			+ "<td>price</td><td>description</td></tr></thead><tbody>";

            $(data).each(function(index, item) {
              output += "<tr><td>" + this.id + "</td>"
              		 +  "    <td>" + this.name + "</td>"
             		 +  "    <td>" + this.price + "</td>"
              		 +  "    <td>" + this.description + "</td></tr>";
            }) // each end

            output += "</tbody></table>";
            $("button").after(output); // 테이블을 컨테이너에 추가합니다.
          } else {
            $("button").after("<div>데이터가 존재하지 않습니다.</div>");
          }
        }); // get end
      }); // click end
    }); // ready end
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-info">JSON 데이터를 불러옵니다.</button>
  </div>
</body>
</html>
