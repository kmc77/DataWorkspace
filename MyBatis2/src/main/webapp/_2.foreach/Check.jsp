<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>조회기간</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>  
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	checkbox 선택에 따라 조건이 변경됩니다.
	1) 선택 없이 검색을 클릭한 경우
		select * form emp order by deptno
		
	2) 10을 선택한 경우
		select from emp
		where deptno in (10) order by deptno
	3) 10과 20을 선택한 경우
		select * from emp
		where deptno in ( 10, 20 )
		order by deptno
		
	4) 10과 20과 30을 선택한 경우
		select * from emp
		where deptno in ( 10, 20, 30 )
		order by deptno		
		
		선택된 값을 배열에 넣은 후 map으로 넘긴 경우	
 --%>
	<form action="${pageContext.request.contextPath}/check.emp" method="post">
		<label>부서번호</label>
		<input type="checkbox" name="deptno" value="10">10
		<input type="checkbox" name="deptno" value="20">20
		<input type="checkbox" name="deptno" value="30">30
		<input type="submit" value="검색">
	</form>

</body>
</html>