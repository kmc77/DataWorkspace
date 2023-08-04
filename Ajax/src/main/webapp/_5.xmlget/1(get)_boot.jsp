<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>XML 형식의 데이터 가져오기</title>
  <style>
    td:nth-child(3n) { text-align: right; }
  </style>
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script>
    $(function() {
      $("button").click(function() { // 버튼이 클릭되었을 때
        $.get("item.xml", function(data) { // data에는 item.xml의 내용이 담겨있습니다.
          // 기존의 테이블이 있으면 중복 방지를 위해 제거합니다.
          $("table").remove(); //테이블이 존재하면 제거해 계속 추가 되지 않도록 합니다.

          let output = "<table class='table'><thead>"
          + "<tr><th>id</th><th>name</th><th>price</th>"
          + "<th>description</th></tr></thead><tbody>";

          $(data).find('item').each(function() {
            //each() : 반복적인 메서드로, 아이템을 찾을 때마다 아래 문장들이 반복적으로 실행됩니다.
            //현재 처리중인 아이템 태그를 this로 접근합니다.
            //$(this)를 이용해 jQuery 객체를 생성합니다.
            output += "<tr>"
            + "<td>" + $(this).attr("id") + "</td>"
            + "<td>" + $(this).attr("name") + "</td>"
            + "<td>" + $(this).find("price").text() + "</td>"
            + "<td>" + $(this).find("description").text() + "</td>"
            + "</tr>";
            /*
            $(this).attr("id") : id 속성의 값을 가져옵니다.
            $(this).find("price") : price 태그를 찾습니다.
            $(this).find("price").text() : price 태그 사이의 값을 가져옵니다.
            $(this).find("description") : description 태그를 찾습니다.
            $(this).find("description").text() : description 태그 사이의 값을 가져옵니다.
            */
          }); //each end

          output += "</tbody></table>";
          $(".container").append(output); // 테이블을 컨테이너에 추가합니다.
        }); // get end
      }); // click end
    }); // ready end
  </script>
</head>
<body>
  <div class="container">
    <button class="btn btn-info">XML 형식 데이터 가져오기</button>
  </div>
</body>
</html>
