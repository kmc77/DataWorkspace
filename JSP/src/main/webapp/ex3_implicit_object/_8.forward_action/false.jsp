<%@ page contentType="text/html; charset=EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>파라미터 출력</title>
</head>
<body>
	name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>
	
	<!-- name 파라미터의 값을 대문자로 변환하여 출력 -->
	<!-- 현재 페이지를 실행하면 errorNullPointer.jsp가 실행된다 -->
	<!-- 주소창에 ?name=hong를 입력하면 정상적으로 'name 파라미터 값: HONG'이 출력된다 -->
</body>
</html>