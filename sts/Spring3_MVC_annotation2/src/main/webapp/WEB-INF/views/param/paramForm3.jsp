<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>입력 폼 입니다.</title>
<link href="resources/css/form.css" type="text/css" rel="stylesheet">
</head>
<body>

<form method="post" action="param3.do">
	<h3>paramForm3.jsp</h3>
		<b>나이</b>
		<input type="text" name="age" placeholder="Enter age" required>
	<div class="clearfix">
		<button type="submit" class="submitbtn">전송</button>
	</div>
</form>

</body>
</html>