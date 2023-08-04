<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>dispatcher.jsp</title>
<style>
	body{background:pink;}
	div{color:red}
	p{color:green}
</style>
</head>
<body>
<!-- request객체의 getParamter()메서드를 이용해서 파라미터 "food"의 값을 가져옵니다. -->
<%-- jsp에서 <%=값 또는 수식 또는 변수 %>  '값 또는 수식 또는 변수' 를 출력하라는 의미입니다.--%>
	<div>
	 request 파라미터 값 : <%=request.getParameter("food") %>
	</div>
	<p>
		보여주는 페이지 주소 입니다. : <%=request.getRequestURL() %>
	</p>	
</body>
</html>
<%-- 실행 후 주소란을 꼭 확인해 보세요.
	브라우저에 주소 표시줄이
--%>