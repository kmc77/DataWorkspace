 <%@ page contentType = "text/html; charset=euc-kr" %>
 
 
<html>
<head>
<title>파라미터 출력</title></head>

<body>
	name 파라미터 값: <%= request.getParameter("hong").toUpperCase() %>
	<%-- name 파라미터의 값을 대문자로 변환하여 출력합니다. --%>
</body>
</html> 