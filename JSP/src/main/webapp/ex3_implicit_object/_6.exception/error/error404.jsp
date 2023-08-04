<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Application Test - 404에러 설정하기</title>
</head>
<style>	
	@keyframes colorAnimation {
  		0% { color: red; }
  		25% { color: blue; }
  		50% { color: green; }
  		75% { color: yellow; }
  		100% { color: purple; }
	}
	html, body {background: lightyellow}
	h1 {animation: colorAnimation 5s infinite}
	div, h1 {text-align: center; font-size: 40px}
	p {font-weight: bold}
</style>
<body>
	<h1>404 error</h1>
	<div>
		<p>요청한 페이지는 존재하지 않습니다<p>
		주소를 올바르게 입력했는지 확인해보시기 바랍니다.
	</div>
</body>
</html>