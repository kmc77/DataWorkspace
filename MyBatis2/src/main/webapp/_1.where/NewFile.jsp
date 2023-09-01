<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<title>조회기간</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%--
		조회기간 날짜를 반드시 입력합니다.
		select * from emp
		where hiredate between ? and ?
	 --%>

	<form action="${pageContext.request.contextPath}/term.emp" method="post">
		<label>조회기간</label><br>
		<input type="date" name="startday" min="1980-01-01" max="1987-12-31" required>
		~<input type="date" name="endday" min="1980-01-01" max="1987-12-31" required>
		<input type="submit" value="검색">
	</form>
</body>
</html>