<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<title>회원리스트 - list</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
	.container{width:500px; margin:0 auto}
	legend{test-align:center; color:#17a2b8}
</style>
<script src="js/jquery-3.7.0.js"></script>
</head>
<body>
<div class="container">
<fieldset>
<legend>회원 리스트</legend>
<table class="table">
  <tr>
	<th>아이디</th><th>비밀번호</th><th>수정</th><th>삭제</th>
	</tr>
	
	<c:forEach var="member" items="${list}">
    <tr>
        <td>${member.id }</td>
        <td>${member.password}</td>
        <td><button class="btn btn-info btn-sm" type="button" data-id="${member.id}">수정</button>
        </td>
        <td>
            <c:if test="${member.id!='admin'}">
                <button class="btn btn-danger btn-sm" type="button" data-id="${member.id}">삭제</button>
            </c:if>
        </td>
    </tr>
</c:forEach>
	</table>
	<div><a href="main.net">메인으로</a></div>		
	</fieldset>	
	</div>
	<script>
		$(".btn-info").click(function(){
			const id = $(this).attr("data-id");
			location.href='updateForm.net?id='+id;
		})
		
		$(".btn-danger").click(function(){
			const id = $(this).attr("data-id");
			if(confirm("정말 삭제 하시겠습니까?")){
			location.href='delete.net?id='+id;
			}
		})
	
	</script>
</body>
</html>