<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
request.setCharacterEncoding("utf-8");
    
 <html>
 <head>
 <title>Application Test - 초기화 파라미터 읽어오기</title>
 <style>
 	div{background:<%=application.getInitParameter("color")%>}
 </style>
 </head>
 
 <body>
 	<h2>wdb.xml에서 설정한 색상으로 지정</h2>
 	
 	 <div>나는 무슨 색인가요?<%= application.getInitParameter("parameter1") %></div>
 	 
 	 
</body>
</html>