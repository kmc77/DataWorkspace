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
          $("table").remove();

          let output = "<table class='table'><thead>"
          	  + "<tr><th>id</th><th>name</th><th>price</th>"
          	  + "<th>description</th></tr></thead><tbody>"

          $(data).find('item')
          .each(function() {
            const id = $(this).attr('id');
            const name = $(this).attr('name');
            const price = $(this).find('price').text();
            const description = $(this).find('description').text();

            output += "<tr>";
            output += "<td>" + id + "</td>";
            output += "<td>" + name + "</td>";
            output += "<td>" + price + "</td>";
            output += "<td>" + description + "</td>";
            output += "</tr>";
          });

          output += "</tbody></table>";

          $("div.container").append(output); // 테이블을 컨테이너에 추가합니다.
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
