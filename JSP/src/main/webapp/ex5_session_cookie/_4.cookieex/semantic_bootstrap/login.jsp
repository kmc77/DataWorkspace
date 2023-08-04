<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쿠키를 이용한 아이디 기억하기</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.js"></script>
<style>
.container {
	margin: 3em auto;
	border: 1px solid lightgray;
	width: 500px
}
</style>
<script>
// 사용자의 ID를 쿠키에 저장하는 함수
function setRememberMe() {
    const rememberMeChecked = $("#remember").prop("checked");
    if (rememberMeChecked) {
        const userId = $("#id").val();
        document.cookie = "remember_me=" + userId + "; expires=Thu, 31 Dec 2030 00:00:00 UTC; path=/";
    } else {
        // 체크박스가 해제되면 remember_me 쿠키를 제거합니다.
        document.cookie = "remember_me=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
    }
}

// "아이디 기억하기" 체크박스가 쿠키에 따라 선택되어야 할지 확인하는 함수
function checkRememberMe() {
    const userId = getCookie("remember_me");
    if (userId) {
        $("#id").val(userId);
        $("#remember").prop("checked", true);
    }
}

// 특정 쿠키의 값을 가져오는 함수
function getCookie(name) {
    const value = "; " + document.cookie;
    const parts = value.split("; " + name + "=");
    if (parts.length === 2) {
        return parts.pop().split(";").shift();
    }
}

$(document).ready(function() {
    // 폼이 로드될 때 "아이디 기억하기" 체크박스가 선택되어야 할지 확인합니다.
    checkRememberMe();

    // 체크박스가 선택되거나 선택 해제될 때 사용자의 ID를 쿠키에 저장합니다.
    $("#remember").change(function() {
        setRememberMe();
    });
});
</script>
</head>
<body>
	<div class="container">
		<form action="login_ok.jsp" method="post" class="border-light p-5">
			<p class="h4 mb-4 text-center">login</p>
			<div class="form-group">
				<label for="id">id</label> <input type="text" class="form-control"
					id="id" placeholder="Enter id" name="id">
			</div>
			<div class="form-group">
				<label for="pass">Password</label> <input type="Password"
					class="form-control" id="pass" placeholder="Enter Password"
					name="Passwd">
			</div>

			<div class="form-group custom-control custom-checkbox">
				<input type="checkbox" class="custom-control-input" id="remember"
					name="remember" value="store"> <label
					class="custom-control-label" for="remember">아이디 기억하기</label>
			</div>

			<button type="submit" class="btn btn-info my-4 btn-block">Submit</button>
		</form>
	</div>
</body>
</html>