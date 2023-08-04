<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
    <title>EL 내장객체 사용 예제</title>
</head>
<body>
        <h3>넘어온 이름은 : ${param.name }</h3>
        <h3>넘어온 취미는 
        ${c:forEach.hobby[0] } ,
        ${c:forEach.hobby[1] }</h3>
        
     <h3>page영역의 속성 id의 값 : ${pageScope.id }</h3>
  	 <h3>request영역의 속성 id의 값 : ${requestScope.id }</h3>
  	 <h3>session영역의 속성 id의 값 : ${sessionScope.id }</h3>
  	 <h3>application영역의 속성 id의 값 : ${applicationScope.id }</h3>
  	 <h3>page -> request -> session -> application 영역에서 속성 id의 값을 찾습니다.
  	 	: ${id }</h3>
  	 
</body>
</html>
