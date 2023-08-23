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
		$(document).ready(function() {  
			$('form').submit(function(){
				start = $('input:eq(0)').val();
				end = $('input:eq(1)').val();
				if(start=='' && end != ''){
					alert("start 날짜를 선택하세요");
					return false;
				} else if (start !='' && end == ''){
					alert("end 날짜를 선택하세요");
					return false;
				} else if (start > end){
					alert('시작날짜와 끝날짜를 확인해주세요');
					return false;
				}
			});
		});
	</script>
</head>
<body>
	<%--
		1. 날짜를 입력하지 않고 검색을 클릭한 경우에는 where절 실행하지 않도록 합니다.
			select *
			from emp
			
		2. 날짜를 입력하는 경우
			select * from emp
			where hiredate between ? end ?

	 --%>

	<form action="${pageContext.request.contextPath}/term2.emp" method="post">
		<label>조회기간</label><br>
		<input type="date" name="startday" min="1980-01-01" max="1987-12-31">
		~<input type="date" name="endday"  min="1980-01-01" max="1987-12-31">
		<input type="submit" value="검색">
	</form>
</body>
</html>
