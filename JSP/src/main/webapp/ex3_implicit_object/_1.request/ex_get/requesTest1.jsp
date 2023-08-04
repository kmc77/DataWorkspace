<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
 
<!DOCTYPE html>
<html>
<head>
  <title>Request Test (requestTest1_Form.jsp)</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <style>
    .container {
      width: 70%;
      text-align: center;
    }
  </style>
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
</head>
<body>
  <div class="container">
    <h3>이것은 요청 예제입니다.</h3>
    <form action="table">
      <table class="table">
        <tr>
          <td>이름</td>
          <td>
            <%-- name 매개변수의 값을 표현식으로 받아옵니다. --%>
            <%= request.getParameter("name") %>
          </td>
        </tr>
        <tr>
          <td>성별</td>
          <td>
            <%
            if (request.getParameter("gender").equals("male")) {
            %>
              남자
            <%
            } else {
            %>
              여자
            <%
            }
            %>
          </td>
        </tr>
        <tr>
          <td>취미</td>
          <td>
            <%-- hobby라는 매개변수는 여러 값을 가질 수 있으므로,
            getParameterValues() 메서드를 사용하여 String 배열로 값을 받아옵니다. --%>
            <%
            String[] hobbies = request.getParameterValues("hobby");
            for (String hobby : hobbies) {
            %>
              <%= hobby %>
            <%
            }
            %>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
