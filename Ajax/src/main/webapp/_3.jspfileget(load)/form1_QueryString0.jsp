<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ajax</title>
<link href="../css/form1.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--
	form태그의 action 속성 없습니다. 이 상태에서 전송을 클릭하면 현재 URL를 다시 불러옵니다.
 --%>
	<form >
		<span>이름</span>
		<input type="text" placeholder="이름" id="name" name="name" required><br>
		<span>나이</span>
		<input type="text" placeholder="나이" id="age" name="age" required><br>
		<span>주소</span>
		<input type="text" placeholder="주소" id="address" name="address" required><br>
		<input type="submit" value="전송">
	</form>
		<div></div>
</body>
</html>
