 <%@ page contentType = "text/html; charset=euc-kr" %>
 
 
<html>
<head>
<title>파라미터 출력</title></head>

<body>
	name 파라미터 값: <%= request.getParameter("hong").toUpperCase(); %>
	<%-- ;을 추가했습니다 --%>
</body>
</html> 