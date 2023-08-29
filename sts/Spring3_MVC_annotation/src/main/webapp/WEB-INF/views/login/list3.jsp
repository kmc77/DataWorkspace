<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>입력한 ID. 비밀번호 출력 - list3</title>
<link href="resources/css/form.css" type="text/css" rel="stylesheet">
<style>
	.container{width:30%}
	h3{text-align:center;color:gray;margin-top:10%}
</style>
</head>
<body>
	<div class="container">
	<h3>list3.jsp 입니다.</h3>
	
	<table class="table">
	<tr>
		<td>ID</td><td>${hoho.id}</td>
	</tr>
	<tr>
		<td>비밀번호</td><td>${hoho.pass}</td>
	</tr>
	
	</table>
	</div>

</body>
</html>