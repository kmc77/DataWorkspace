<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>조회기간</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>  
	<script>
	
	</script>
</head>
<body>
	<%--
		   조회 조건 : 맵에 저장시 <String, String>형으로 사용
		1. 입력 없는 상태에서 검색을 클릭한 경우
			select * from emp;
			
		2. 조회 기간만 입력한 경우
			select * from emp where hiredate between ? end ?

		3. 부서번호만 입력한 경우
			select * from emp WHERE deptno = ?
		
		4. 조회 기간과 부서번호를 입력한 경우
			select * from emp
			WHERE hiredate between ? end ?
			and deptno=?	
	 --%>

	<form action="${pageContext.request.contextPath}/term3.emp" method="post">
		<label>조회기간</label><br>
		<input type="date" name="startday" min="1980-01-01" max="1987-12-31">
		~<input type="date" name="endday"  min="1980-01-01" max="1987-12-31">
		<input type="submit" value="검색">
	</form>
</body>
</html>
