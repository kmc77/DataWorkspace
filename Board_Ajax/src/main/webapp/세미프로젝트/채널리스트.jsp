<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>채널리스트</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
.container {
	max-width: 1200px;
	margin: auto;
	background-color: #9e9e9eb5;
}

.buttons-container {
	display: flex;
	justify-content: center;
}

.bt-item {
	margin: 0 5px;
	color: #01273C;
	font-weight: bold;
	border-radius: 12px;
	border: 1px solid #01273C;
	font-size: 15px;
	text-align: center;
	line-height: 18px;
	position: relative;
	overflow: hidden;
	background: transparent;
	cursor: pointer;
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

.footer {
	position: absolute;
	top: 100%;
	background: #01273C;
	width: 100%;
}

.footer-row {
	width: 180px;
}

.footer-table, .footer-span {
	font-size: 8px;
}

.footer-color {
	color: #c9c9c9 !important;
}

.rounded-circle {
	width: 7rem;
	height: 7rem;
}

.row.area {
	width: 900px;
	margin: 0 auto;
	padding: 20px 0;
}

.col-md-4 {
	padding: 0px;
}

.card {
	margin: 0 auto;
	background-color: white;
	overflow: hidden;
	transition: all 0.3s ease-in-out;
	width: 260px;
	height: 300px;
}

.card img {
	margin: 30px;
}

.card-body {
	text-align: center;
}

.card-title,
.card-text {
  text-decoration: none;
}
</style>

<script>
	$(function() {
		$(".bt-item").click(function() {
			$(".bt-item.on").remove
			Class('on');
			console.log('test');
			$(this).addClass('on').css("box-shadow", "none");
		});
	});
</script>
</head>
<body>
	<div style="display: flex; justify-content: center;">
		<h1>잇다 채널 추천</h1>
	</div>
	<div class="buttons-container">
		<div class="cate-button">
			<!-- 스타일  -->
			<button class="btn bt-item bt-hover">
				<span>부동산</span>
			</button>
			<button class="btn bt-item bt-hover">
				<span>요리</span>
			</button>
			<button class="btn bt-item bt-hover">
				<span>취미/학습</span>
			</button>
			<button class="btn bt-item bt-hover">
				<span>스포츠/건강</span>
			</button>
			<button class="btn bt-item bt-hover">
				<span>책/작가</span>
			</button>
		</div>
	</div>

	<div class="container">
		<div class="row area">
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/man.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">달다</h5>
							<p class="card-text">깊고 느리게, 쓰고 그립니다.</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/woman.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">소위</h5>
							<p class="card-text">삶이 민들레 홀씨처럼 가볍고 정처없었습니다. 오늘도 글을 쓰며 가만히 내려앉고 있습니다.</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/man.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">Card 3</h5>
							<p class="card-text">채널명3</p>
						</div>
					</div>
				</a>
			</div>
		</div>
		<div class="row area">
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/woman.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">효라빠</h5>
							<p class="card-text">18년차 교도관 입니다. 운동(유도,주짓수 등)과 책읽기, 글쓰기를 좋아합니다. 50가지의 독특한 교도소 이야기로 책 출간했습니다. 다양한 글을 쓰고 싶습니다.</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/man.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">김별</h5>
							<p class="card-text">여행기 <일단 떠나라> 저자 ~ 여행을 일상처럼, 일상을 여행처럼 자유로이 오가며~ 찰나 적 성찰을 낚아 올려 기록하고 싶다. 글쓰기는 내가 몰입할 수 있는 가장 의미 있는 일이다</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="#">
					<div class="card d-flex justify-content-center">
						<img src="../image/woman.png"
							class="card-img-top rounded-circle mx-auto d-block" alt="...">
						<div class="card-body">
							<h5 class="card-title">기자</h5>
							<p class="card-text">오롯이 '지금 이 순간'에 집중해 행복함을 추구하는 LA 드리머</p>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="footer-container footer-color">
			<p style="font-weight: bold; font-size: 15px;">잇:다(주) 사업자 정보</p>
			<table class="footer-table footer-color">
				<tr class="footer-row">
					<td>사업자 등록번호</td>
					<td>220-81-62517</td>
				</tr>
				<tr>
					<td>전화 번호</td>
					<td>1588-1588</td>
				</tr>
				<tr class="footer-row">
					<td>이메일</td>
					<td>itda@itda.com</td>
				</tr>
				<tr class="footer-row">
					<td>주소</td>
					<td>서울 종로구 청와대로 1</td>
				</tr>
				<tr class="footer-row">
					<td>호스팅 서비스 제공</td>
					<td>NAVER Cloud</td>
				</tr>
			</table>
			<br> <span class="footer-span footer-color">네이버(주)는
				통신판매중개시스템의 제공자로서 통신판매의 당사자가 아닙니다. 콘텐츠 판매, 환불 등과 관련한 의무와 책임은 판매자에게
				있습니다.</span> <br> <img src="../img_pro/itda_logo2.png"
				style="width: 100px; height: auto; margin: 0px;" alt="흰색 로고">
		</div>
	</footer>
</body>
</html>
