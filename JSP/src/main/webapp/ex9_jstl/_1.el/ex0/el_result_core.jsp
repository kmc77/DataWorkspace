<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
    <title>EL 내장객체 사용 예제</title>
</head>
<body>
        <h3>넘어온 이름은 : ${param.name }</h3>
        <h3>넘어온 취미는 :
        <c:forEach var="ho" items="${paramValues.hobby}">
        		<c:out value="${ho}"/>
        </c:forEach>		
		</h3>
		
		        
     <h3>session영역의 속성 id의 값 : ${sessionScope.id }</h3>
  	 <h3>${id }</h3>
  	 
</body>
</html>
