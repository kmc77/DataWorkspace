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
<div class="container">
	<c:if test="${!empty list }">
		<table class="table table-striped">
			<tr>
				<td>조건문</td>
				<td colspan="5">
					<c:if test="${!empty start && !empty end}">
						<div class='red'>
										입사일 : ${start} ~ ${end}
						</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>사원번호</td>
				<td>직책</td>
				<td>입사일</td>
				<td>부서번호</td>
			</tr>
			<c:forEach items="${list}" var="emp" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${emp.ename}</td>
					<td>${emp.empno}</td>
					<td>${emp.job}</td>
					<td>${emp.hiredate}</td>
					<td>${emp.deptno}</td>
				</tr>
			</c:forEach>
		</table>
</c:if>
<c:if test="${empty list }">
	조건을 만족하는 데이터가 없습니다.
</c:if>
</div>
</body>
</html>