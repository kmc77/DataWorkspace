<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 성공</title>
</head>
<body>
	<%=session.getAttribute("id") %>님 로그인에 성공하셨습니다.
	<a href="logout.jsp">로그아웃</a>
</body>
</html>