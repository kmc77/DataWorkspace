<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>파라미터 출력</title>
</head>
<body>
	name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>
	
	<!-- name 파라미터의 값을 대문자로 변환하여 출력 -->
	<!-- 끝에 ;를 추가하여 실행하면 500.jsp가 실행된다 -->
</body>
</html>