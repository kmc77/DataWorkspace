<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>scome.jsp</title>
<link href="../../css/ch03-5.css" type="text/css" rel="stylesheet">
</head>
<body>
	request 加己 food 蔼 : <%=request.getAttribute("food") %><br>
	session 加己 food 蔼 : <%=session.getAttribute("food") %><br>
	ServletContext 加己 food 蔼: <%=application.getAttribute("food") %>
	
</body>
</html>