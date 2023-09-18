<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>common 오류</title>
<style>
</style>
</head>
<body>
	<h1>common.jsp</h1>
	죄송합니다.<br>
	<img src="${pageContext.request.contextPath }/resources/image/tear3.png" width="100px"><br>
	요청하신 <b> ${url }</b> 처리에 오류가 발생했습니다.
	<hr>
	${exception }

</body>
</html>