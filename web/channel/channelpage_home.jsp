<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<jsp:include page="header.jsp" />
<script src="../js/category.js"></script>
<html lang="kor">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>channel Page</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
.wrapper {
	display: grid;
	place-items: center;
	min-height: 100dvh;
}

body {
	background-color: #CCCCCC;
}

#profile {
	background-color: #D9D9D9;
	width: 240px;
	height: 240px;
	margin: 50px;
	display: inline-block;
}

.bt-item {
	/*position: relative;*/
	margin: 0 5px;
	color: #01273C;
	font-weight: bold;
	border-radius: 12px;
	border: 1px solid #01273C;
	width: 7em;
	font-size: 15px;
	text-align: center;
	line-height: 20px;
}

.bt-hover:hover, .on, .bt-on {
	background: #FBD1A7;
	color: #01273C;
	opacity: 0.8;
	border: 1px solid #FBD1A7;
}

.bt-item:active {
	border: none;
}

.bt-normal {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 0 5px;
	font-weight: bold;
	height: 33px;
	border-radius: 12px;
	border: 1px solid #01273C;
	width: 7em;
	font-size: 15px;
	text-align: center;
	line-height: 20px;
}

.info_button {
	text-align: right;
}

tr>td:nth-child(odd) {
	font-weight: normal;
	width: 720px;
}

td {
	text-align: left;
}

.container {
	width: 60%; /* 먼저 부모 요소의 가로 너비를 100%로 설정 */
	overflow-x: auto; /* 표의 너비가 부모를 초과하는 경우 가로 스크롤 표시 */
}

a.test:hover {
	text-decoration: underline;
	color: inherit;
}

td>a {
	display: block;
	color: inherit;
}

.category-content {
	width: 100%;
}
</style>
<script>
	$(function() {
		$(".bt-item").click(function() {
			$(".bt-item.on").removeClass('on');
			console.log('test');
			$(this).addClass('on').css("box-shadow", "none");
		});
	});
</script>
</head>
<body>
	<div class="wrapper" style="width: 1250px;">
		<div class="info">
			<br> <br>
			<h3>[책장 위 고양이]</h3>
			<div id="profile">
				<p>
					안녕하세요:)<br> 세 마리 고양이를 키우는<br> 집사입니다.<br> 잘 부탁드립니다.
				<div class="info_button">
					<button class="btn bt-item bt-hover">자세히보기</button>
				</div>
				</p>
			</div>
			<img src="../image/channel/ccc.jpg"
				style="width: 330px; height: 300px; border-bottom-left-radius: 50px;">
			<br>
			<button class="btn bt-item bt-hover">구독하기</button>
			<img src="../image/alram.png"
				style="width: 40px; height: 40px; margin-left: 10px;"> <br>
			<br>
		</div>
		<hr style="border: 1px bold silver;" width="100%">

		<br>

		<div class="category">
			<input class="btn bt-item bt-hover" type='button' value='홈'
				onclick='setInnerHTML1()' /> <input class="btn bt-item bt-hover"
				type='button' value='카테고리' onclick='setInnerHTML2()' />
		</div>

		<br> <br>
		<div id='my_div'></div>


		<div class="category2">
			<br> <br> <br>
			<div class="bt-normal">공지사항</div>
			<br> <br>
		</div>
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<td><a href="https://www.naver.com/" class='test'>
							[책장위고양이] 시인들의 에세이 </a></td>
					<%-- 공지사항 td에 불러오기 https://stackoverflow.com/questions/10245279/wrapping-html-table-rows-in-a-tags 사이트 참고--%>
				</tr>
				<tr>
					<td><a href="https://www.naver.com/" class='test'> 책장위고양이
							기프티콘 구글 설문지 링크를 다시 보내드립니다. </a></td>
				</tr>
				<tr>
					<td><a href="https://www.naver.com/" class='test'> 책장위고양이
							[기프티콘] 당첨을 축하하오! </a></td>
				</tr>
				<tr>
					<td><a href="https://www.naver.com/" class='test'> 공지사항
							있습니다! </a></td>
				</tr>
				<tr>
					<td><a href="https://www.naver.com/" class='test'>
							[책장위고양이] 같이사는 고양이를 소개합니다. </a></td>
				</tr>
				<tr>
					<td><a href="https://www.naver.com/" class='test'> 반갑습니다!
							앞으로 잘 부탁드립니다. </a></td>
				</tr>
			</table>
		</div>
	</div>
	<br> <br>
</body>
<jsp:include page="footer.jsp" />
</html>