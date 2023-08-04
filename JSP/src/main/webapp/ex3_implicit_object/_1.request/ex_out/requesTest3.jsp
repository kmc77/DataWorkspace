<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
 <%-- 파라미터 한글 처리를 위해  --%>
  <%
  	request.setCharacterEncoding("euc-kr");
  %>
<html>
<head>
  <title>Request Test (requestTest1_Form2.jsp)</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h3>이것은 요청 예제입니다.</h3>
    <form action="table">
      <table class="table">
        <tr>
          <td>이름</td>
          <td>
            <%-- name 파라미터 값을 얻어와서 표현식으로 출력합니다. --%>
            <%= request.getParameter("name") %>
          </td>
        </tr>
        <tr>
          <td>성별</td>
          <td>
            <%
            if (request.getParameter("gender").equals("male")) 
            	{
            		out.print("남자");
            	} else {
            		out.print("여자");
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
	          	out.print(hobby + " ");
            }
            %>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>
