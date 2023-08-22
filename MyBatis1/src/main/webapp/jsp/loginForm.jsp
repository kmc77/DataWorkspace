<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.html</title>
<link href="css/login.css" type="text/css" rel ="stylesheet">
<script src="js/jquery-3.7.0.js"></script>
<script>
	$(function() {
		$(".join").click(function(){
			location.href = "joinForm.net";
		});
	})
</script>
</head>
<body>

<form action="loginPro.net" method="post">

 <h1>로그인 </h1>
 	 <hr>
 	 <b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" id="id" maxLength="10" required>
		
		<b>Password</b>
		<input type="password" name="password" placeholder="Enter password" maxLength="10" required>
		<div class="clearfix">
			<button type="submit" class="submitbtn">로그인</button>
			<button type="button" class="join">회원가입</button>
		</div>
</form>

</body>
</html>
