<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ajax</title>
<link href="../css/form1.css" rel="stylesheet" type="text/css">
 <script src="../js/jquery-3.7.0.js"></script>
 <script>
 
 $(function(){
	    $("form").submit(function(e) {
	        e.preventDefault(); // 기본 이벤트 제거
	        const data_name = "name=" + $("#name").val(); // 쿼리 문자열을 만들 때, 매개변수 이름과 "=" 사이에 공백 없이 작성합니다.
	        const data_age = "age=" + $("#age").val();
	        const data_address = "address=" + $("#address").val();
	        const data = data_name + "&" + data_age + "&" + data_address; // 데이터 변수들을 "&"로 연결합니다.
	         //쿼리스트링 형식으로 파라미터의 이름과 값의 형태로 전달합니다.
	         // $("div").load("process.jsp",
	         //                 "name=love&age=21&address=서울시");
	        $("div").load("process.jsp", data); // 올바른 변수 "data"를 두 번째 인자로 사용합니다.
	    });
	});

 </script>
</head>
<body>
<%--
	form태그의 action 속성 없습니다. 이 상태에서 전송을 클릭하면 현재 URL를 다시 불러옵니다.
 --%>
	<form >
		<span>이름</span>
		<input type="text" placeholder="이름" id="name" name="name" required><br>
		<span>나이</span>
		<input type="text" placeholder="나이" id="age" name="age" required><br>
		<span>주소</span>
		<input type="text" placeholder="주소" id="address" name="address" required><br>
		<input type="submit" value="전송">
	</form>
		<div></div>
</body>
</html>
