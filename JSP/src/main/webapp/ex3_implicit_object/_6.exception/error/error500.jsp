<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Application Test - 500에러 설정하기</title>
</head>
<style>	
	@keyframes colorAnimation {
  		0% { color: red; }
  		25% { color: blue; }
  		50% { color: green; }
  		75% { color: yellow; }
  		100% { color: purple; }
	}
	html, body {background: #f5c05f}
	h1 {animation: colorAnimation 5s infinite}
	div,h1 {text-align: center; font-size: 40px}
	p {font-weight: bold}
</style>
<body>
	<h1>500 error</h1>
	<div>
		<p>요청한 페이지에 서버 내부 에러 발생<p>
		소스 코드의 오타를 확인해 주세요
	</div>
</body>
</html>