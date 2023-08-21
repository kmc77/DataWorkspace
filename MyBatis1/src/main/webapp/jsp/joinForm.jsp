<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
  <title>joinForm.jsp</title>
    <link href="css/login.css"      type="text/css"      rel ="stylesheet">
</head>

<body>
<form action="joinPro.net" method="post">
  <h1>회원가입 </h1>
  <hr>
      <b>아이디</b>
        <input type="text" name="id" maxLength="10" placeholder="Enter id" required>
        <b>Password</b>
        <input type="password" name="password"   maxLength="10" placeholder="Enter password" required>
	       <div class="clearfix">
          <button type="submit" class="join">회원가입</button>
          <button type="reset"  class="cancel">취소</button>
        </div>
</form>
</body>
</html>