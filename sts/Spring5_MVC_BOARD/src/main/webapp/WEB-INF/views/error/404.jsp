<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>404 오류</title>
<style>
	div{text-align:center}
</style>
	</head>
	<body>
	<div>
		${exception}<br>
		<img src="${pageContext.request.contextPath}/resources/image/404.png" width="300px"><br>
		요청하신 <b>${url}</b> 처리에 오류가 발생했습니다.
	</div>
</body>
</html>