<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login.html</title>
<link href="../../css/ch03-1.css" type="text/css" rel ="stylesheet">
</head>
<body>
<!-- 이 페이지의 URL은
	 http://localhost:8088/JSP/ex1/_1.login/login1_get.html을 의미합니다.
	 
	 action의 의미는
	 http://localhost:8088/JSP/ex1/_1.login/LifeCycleTest을 의미합니다.
	 
	 src/main/java 패키지의 하위 패키지 _1.login의 LifeCycleTest.java에서
	 @WebServlet(urlPatterns = "/ex1/_1.login/LifeCycleTest") 또는
	 @WebServlet("/ex1/_1.login/LifeCycleTest") 으로 설정해야 합니다.
	 
 -->

<form action="login_ok.jsp" method="post">

 <h1>로그인 </h1>
 	 <hr>
 	 <b>아이디</b>
		<input type="text" name="id" placeholder="Enter id" required>
		<b>Password</b>
		<input type="text" name="password" placeholder="Enter password" required>
		<div class="clearfix">
			<button type="submit" class="submitbtn">Submit</button>
			<button type="reset" class="cancelbtn">Cancel</button>
		</div>
</form>

</body>
</html>