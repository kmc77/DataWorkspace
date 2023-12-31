<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko" data-useragent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36"><head>
	<meta charset="utf-8">
    <head>
		<meta charset="UTF-8">
        <title>공지사항</title>
        <link rel="canonical" href="https://www.hankyung.com/help">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
        <meta name="robots" content="index,follow">

        <meta name="title" content="고객센터">
        <meta name="description" content="한경 고객센터, 성공을 부르는 습관 한국경제신문 한경닷컴">
        <meta name="author" content="한국경제">

        <meta property="og:title" content="고객센터 | 한국경제">
        <meta property="og:url" content="https://www.hankyung.com/help">
        <meta property="og:type" content="website">
        <meta property="og:description" content="한경 고객센터, 성공을 부르는 습관 한국경제신문 한경닷컴">
        <meta property="og:site_name" content="hankyung.com"/>
        <meta property="og:image" content="https://static.hankyung.com/img/logo/logo-news-sns.png">
        <meta property="og:image:width" content="200">
        <meta property="og:image:height" content="200">

        <meta name="twitter:card" content="summary_large_image">
        <meta name="twitter:title" content="고객센터 | 한국경제">
        <meta name="twitter:description" content="한경 고객센터, 성공을 부르는 습관 한국경제신문 한경닷컴">
        <meta name="twitter:image:src" content="https://static.hankyung.com/img/logo/logo-news-sns.png">

        <meta itemprop="name" content="고객센터 | 한국경제">
        <meta itemprop="description" content="한경 고객센터, 성공을 부르는 습관 한국경제신문 한경닷컴">
        <meta itemprop="image" content="https://static.hankyung.com/img/logo/logo-news-sns.png">

        <link rel="shortcut icon" href="https://www.hankyung.com/favicon.ico">
        <link rel="apple-touch-icon" sizes="192x192" href="https://static.hankyung.com/resource/common/img/favicon/apple-touch-icon.png">
        <link rel="stylesheet" href="https://static.hankyung.com/css/www/w/common.ui.all.css?v=202309211654">
        <link rel="stylesheet" href="https://static.hankyung.com/resource/www/help/css/help.css?v=202309211654">

        <script src="https://static.hankyung.com/plugin/jquery-1.12.4.min.js"></script>
		<script src="https://static.hankyung.com/plugin/jquery.cookie.js"></script>
		<script type="text/javascript" src="https://static.hankyung.com/js/ga/googleTagManager.js?v=202309211654" async="true"></script>
    </head>
    <body>
        <div id="wrap" class="wrap sub">
            <!-- skip navi -->
            <div class="skip_navi">
                <a href="#contents">본문 바로가기</a>
            </div>
            <!-- header -->
          <%--   <header class="header">
                <div class="layout-inner">
                    <div class="header-top">
                        <div class="logo-section">
                            <a href="https://www.hankyung.com/" class="logo-hk"><span class="blind">한국경제</span></a>
                            <h1>
                                <a href="https://www.hankyung.com/help" class="section-title">고객센터</a>
                            </h1>
                        </div>
                        <!-- 로그인 전 -->
<div class="item login-area ms-3 login_link" style="display:none;">
	<a role="button" class="login-link btn-info">
		<svg width="12" height="12" viewBox="0 0 12 12">
			<path d="m9.5,3.5c0,1.9-1.6,3.5-3.5,3.5s-3.5-1.6-3.5-3.5S4.1,0,6,0s3.5,1.6,3.5,3.5Zm-.8,3.6c-.8.6-1.7.9-2.7.9s-1.9-.3-2.7-.9c-2,.9-3.3,3.7-3.3,4.9h12c0-1.2-1.3-4-3.3-4.9Z" class="svg-icon"></path>
		</svg>
		<span id="login_txt" class="txt">로그인</span>
	</a>
</div>

<!-- 로그인 후 -->
<div class="login-area ms-3 login-info" style="display:none;">
	<a role="button" class="login-link btn-info">
		<svg width="12" height="12" viewBox="0 0 12 12">
			<path d="m9.5,3.5c0,1.9-1.6,3.5-3.5,3.5s-3.5-1.6-3.5-3.5S4.1,0,6,0s3.5,1.6,3.5,3.5Zm-.8,3.6c-.8.6-1.7.9-2.7.9s-1.9-.3-2.7-.9c-2,.9-3.3,3.7-3.3,4.9h12c0-1.2-1.3-4-3.3-4.9Z" class="svg-icon"></path>
		</svg>
		<span id="login_txt" class="txt user-name">내정보</span>
	</a>
	<div class="layer-my">
		<div class="user-info">
			<div class="account-info">
				<p class="email">
					<span class="icon-mylogin"><span class="blind"></span></span>
					<span class="txt"></span>
				</p>
			</div>
			<div class="btns">
				<a href="https://id.hankyung.com/user/selectMyPage.do" class="btn-account">계정관리</a>
				<a role="button" class="btn-logout">로그아웃</a>
			</div>
		</div>

		<div class="subscription-info">
			<div class="mypages-area">
				<a href="https://www.hankyung.com/my-news">
					<span class="txt-en">My News</span>
				</a>
				<a href="https://markets.hankyung.com/my-stock">
					<span class="txt-en">My Stock</span>
				</a>
			</div>

			<dl class="details">
				<dt>구독내역</dt>
				<dd class="bioinsight">
					<a href="https://www.hankyung.com/bioinsight">한경 <span class="txt-en">BIO Insight</span></a>
					<a href="https://www.hankyung.com/bioinsight/guide" class="badge-subscribing">구독신청</a>
				</dd>
				<dd class="esg">
					<a href="https://www.hankyung.com/esg">한경 <span class="txt-en">ESG</span></a>
					<a href="https://www.hankyung.com/esg/guide" class="badge-subscribing">구독신청</a>
				</dd>
			</dl>
		</div>
	</div>
</div>

<script>
var url = escape(document.location.href);

// 회원가입 url 설정
$(".login_link .join-link").attr('href', 'https://id.hankyung.com/login/joinPage.do?url=' + url);

// 로그인 url 설정
$(".login_link .login-link").attr('href', 'https://member.hankyung.com/apps.frame/login?url=' + url);

// 로그아웃 url 설정
$(".login-area .btn-logout").attr('href', 'https://member.hankyung.com/apps.frame/login.work.logout?url=' + url);

// 개인정보 url 설정
$(".login-area .btn-account").attr('href', 'https://member.hankyung.com/apps.frame/member.main?url=' + url);



/**************************************************************************************************************/
// [로그인 유지 기능 도입] 시작
// by 현상은 on 2022-07-06
/**************************************************************************************************************/

// 통합회원 아이디
const user_id = $.cookie('UserId');
// 토큰 쿠키
const tokenCookie = $.cookie('ssoToken');

// 세션 체크 필요 여부
let checkFlag = false;


// 쿠키에 회원 아이디가 있는 경우
if( user_id )
{
	// 마지막 세션 체크 시간 쿠키
	const checkTimeCookie = $.cookie('ssoTokenCheckTime');

	if( checkTimeCookie )
	{
		const checkTime = new Date(checkTimeCookie);

		const today = new Date();

		// 오늘 날짜와 마지막 세션 체크일의 차이를 구한다.
		const betweenTimeDay = Math.floor((today.getTime() - checkTime.getTime()) / 1000 / 60 / 60 / 24);

		// 세션을 체크한지 1일이 경과한 경우 세션 체크 API를 호출한다.
		if( betweenTimeDay > 0 )
		{
			checkFlag = true;
		}
		else
		{
			setLogin(true);
		}
	}
	else
	{
		// 세션 체크 기록이 없으면 세션 체크 API를 호출한다.
		checkFlag = true;
	}
}
else
{
	// 토큰 쿠키가 있는 경우
	if( tokenCookie )
	{
		checkFlag = true;
	}
	// 토큰 쿠키가 없는 경우
	else
	{
		setLogin(false);
	}
}


// 세션 체크가 필요한 경우에만 API를 호출한다.
if( checkFlag == true )
{
	$.ajax({
		type : "POST",
		url : "https://member.hankyung.com/apps.frame/sso.check.token",
		crossDomain: true,
		dataType: 'jsonp',
		jsonp: 'jsonp_callback',
		data : {'token' : tokenCookie,
				'key' : "a8bdf898783883b64503b8915deeb57767f935a24daf44150723299c01c8898a",
				'fn' : "setLogin"
		}
	});
}



function setLogin(result)
{
	if(result == true || result.result_code == "0000")
	{
		// 세션 체크 API 결과가 정상인 경우 현재 날짜를 세션 체크 쿠키에 셋팅한다.
		if( result.result_code == "0000" )
		{
			// 현재 날짜를 가져온다.
			const now = new Date();
			const year	= now.getFullYear();
			const month	= ('0' + (now.getMonth() + 1)).slice(-2);
			const day	= ('0' + now.getDate()).slice(-2);
			const dateString = year + '-' + month  + '-' + day;

			// 브라우저 종료시 만료되는 쿠키를 셋팅한다.
			$.cookie('ssoTokenCheckTime', dateString, { expires: null, path: '/', domain: 'hankyung.com'});
		}




		// 이름대신 통합회원ID 입력
		// $(".login-info .user-name").text($.cookie("SSOid").split('@')[0]+'님');
		// $(".login-info .user-info .account-info .email").text($.cookie("SSOid"));

		// $(".login_link").hide();
		// $(".login-info").show();


		// 이름대신 통합회원ID 입력
		var iconLoginType = 'icon-mylogin-hk';
		if($.cookie("login_type")){
			iconLoginType = 'icon-mylogin-'+$.cookie("login_type");
		}
		var textLoingTypes = {
			'icon-mylogin-hk':'한경으로 로그인',
			'icon-mylogin-email':'한경으로 로그인',
			'icon-mylogin-kakao':'카카오로 로그인',
			'icon-mylogin-naver':'네이버로 로그인',
			'icon-mylogin-google':'구글로 로그인',
			'icon-mylogin-apple':'애플로 로그인'
		}

		var textLoingType = textLoingTypes[iconLoginType];

		$(".login-info .user-info .account-info .email span.icon-mylogin").addClass(iconLoginType).removeClass('icon-mylogin');
		$(".login-info .user-info .account-info .email span.blind").text(textLoingType);

		$(".login-info .user-info .account-info .email .txt").text($.cookie("SSOid"));

		$(".login_link").remove();
		$(".login-info").show();

	}
	else
	{
		// $(".login_link").show();
		// $(".login-info").hide();

		$(".login-info").remove();
		$(".login_link").show();
	}
}

/**************************************************************************************************************/
// [로그인 유지 기능 도입] 종료
/**************************************************************************************************************/

function getPaymentCheck(){
	$.ajax({
		url: 'https://www.hankyung.com/action/checkPayment'
		, async: false
		, type: 'POST'
		, data:{
			userId: $.cookie('SSOid')
			, PayNews: $.cookie('PayNews')
			, PayNews_esg: $.cookie('PayNews_esg')
		}
		, success: function(result){
			$.each(result, function(idx, val){
				if(val == 'Y'){
					$(".login-info .subscription-info dd."+idx+" .badge-subscribing").text("구독내역");
					$(".login-info .subscription-info dd."+idx+" .badge-subscribing").attr("href", "https://www.hankyung.com/"+idx+"/mypage/pay");
				}else{
					$(".login-info .subscription-info dd."+idx+" .badge-subscribing").text("구독신청");
					$(".login-info .subscription-info dd."+idx+" .badge-subscribing").attr("href", "https://www.hankyung.com/"+idx+"/guide");
				}
			});
		}
		, error: function(xhr, status, responseTxt){
			console.log(xhr);
		}
	});
}

// 사용자명 클릭
$('.user-name').on("click", function(e){
	e.preventDefault();
	getPaymentCheck();
	$('.layer-my').toggleClass('active');
});

$(document).on('mouseup',function(e){
	// 사용자 정보 off
	if (!$(e.target).is('.layer-my') && !$(e.target).parents().is('.layer-my') && !$(e.target).is('.login-link') && !$(e.target).is('.icon-myinfo') && !$(e.target).is('.tool-user *')){
		$('.layer-my').removeClass('active');
	};

	// 전체메뉴창 off
	if (!$(e.target).hasClass('layer-allmenu') && !$(e.target).parents().hasClass('layer-allmenu') && !$(e.target).hasClass('btn-allmenu') && !$(e.target).parents().hasClass('btn-allmenu')) {
		$('.layer-allmenu').removeClass('active');
		$('body').removeClass("open-allmenu");
	};

	// 검색창 off
	if (!$(e.target).is('.layer-search') && !$(e.target).parents().is('.layer-search')){
		$('.search-area').removeClass('active');
	};

	// 하위 서브메뉴 off(탑헤더, 메인 gnb)
	if (!$(e.target).is('.gnb-dropdown-menu') && !$(e.target).parents().is('.gnb-dropdown-menu') && !$(e.target).parents().is('.gnb-dropdown-menu, .gnb-dropdown-toggle')){
		$('.gnb-dropdown').removeClass('focus');
		$('.gnb-dropdown.type-click').removeClass('active');
		$('.gnb-dropdown.type-click .gnb-dropdown-menu').slideUp();
	};
});

// 스크롤 이동 시 내정보 레이어 삭제
$(window).scroll(function(){
	$('.layer-my').removeClass('active');
})

// 오늘날짜 구하기
const weekDay = ['일', '월', '화', '수', '목', '금', '토'];
let topToday = new Date();

let topYear = topToday.getFullYear()
, topMonth = topToday.getMonth() + 1
, topDay = topToday.getDate();

if(topMonth < 10) topMonth = '0'+topMonth;
if(topDay < 10) topDay = '0'+topDay;

$(".today-info").html('<span class="txt-date">'+topYear+'.'+topMonth+'.'+topDay+'</span> '+weekDay[topToday.getDay()]+'요일');

// family site 클릭
$('.gnb-section:not(.type-hover) .gnb-dropdown-toggle, .gnb-dropdown.type-click .gnb-dropdown-toggle').on("click", function(e){
	e.preventDefault();
	var gnbDropdown = $(this).parents('.gnb-dropdown');
	if (gnbDropdown.hasClass('active')) {
		gnbDropdown.removeClass('active');
		gnbDropdown.find('.gnb-dropdown-menu').slideUp();
	}else {
		$('.gnb-dropdown.type-click').removeClass('active');
		$('.gnb-dropdown.type-click .gnb-dropdown-menu').slideUp();
		gnbDropdown.addClass('active');
		gnbDropdown.find('.gnb-dropdown-menu').slideDown();
	}
	return false;
});
</script>                    </div>
                    <ul class="gnb-section">
                        <!-- [D] 활성화 클래스 on -->
                        <li class="on"><a href="https://www.hankyung.com/help/notice" target="">공지사항</a></li>
                        <li ><a href="${pageContext.request.contextPath}/main/faq" target=""><span class="txt-en">FAQ</span></a></li>
                        <li ><a href="https://www.hankyung.com/help/qna" target="">1:1문의<span class="icon-membersonly2">회원전용</span></a></li>
                    </ul>
                </div>
            </header> --%>
            <!-- // header -->

            <!-- contents -->
<!-- contents -->
		<div id="contents" class="contents">
			<div class="layout-inner">
				<section class="notice-wrap">
					<h1 class="cont-tit">공지사항</h1>
					
					<ul class="faq-menu-list">

					<li class="on"><a href="${pageContext.request.contextPath}/info/customerService" target="">공지사항</a></li>
					<li ><a href="${pageContext.request.contextPath}/info/faq">FAQ</a></li>
					<li ><a href="${pageContext.request.contextPath}/info/help">1:1문의<span class="icon-membersonly2">회원전용</span></a></li>
				</ul>
					
					<div class="list-basic">
					
					
					

						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=54"
									class="notice-tit">한경 회원전용 콘텐츠(기사) 설문조사에 참여해주세요.</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.09.13</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=53"
									class="notice-tit">한경닷컴 휴면회원 정책이 폐지됩니다.</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.08.14</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=50"
									class="notice-tit">개인정보처리방침 개정 및 휴면정책 변경 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.08.14</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=48"
									class="notice-tit">한경 고객센터 오픈안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.06.30</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=47"
									class="notice-tit">기사뷰 프린트 서비스 종료 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.06.01</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=46"
									class="notice-tit">한국경제 소셜 로그인 오픈 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2023.04.10</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=42"
									class="notice-tit">한경온리 회원 서비스 업데이트 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2022.08.22</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=41"
									class="notice-tit">기사뷰 개편 및 신규 서비스 'My News' 오픈 알림</a>
							</div>
							<div class="col">
								<span class="txt-num">2022.06.30</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=40"
									class="notice-tit">프린트, 클린뷰 서비스 회원전용 변경 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2022.06.30</span>
							</div>
						</div>
						<div class="list-item ">
							<div class="col tit">
								<a href="https://www.hankyung.com/help/notice/view?no=37"
									class="notice-tit">증권 서비스 My관심종목, My포트폴리오 종료 안내</a>
							</div>
							<div class="col">
								<span class="txt-num">2022.03.08</span>
							</div>
						</div>
					</div>

					<div class="pagination" role="navigation">
						<a href="https://www.hankyung.com/help/notice?page=1"
							class="btn-page-first"> <span class="blind">처음</span>
						</a> <a href="https://www.hankyung.com/help/notice?page=1"
							class="btn-page-prev"> <span class="blind">이전</span>
						</a> <strong>1</strong> <a
							href="https://www.hankyung.com/help/notice?page=2">2</a> <a
							href="https://www.hankyung.com/help/notice?page=3">3</a> <a
							href="https://www.hankyung.com/help/notice?page=4">4</a> <a
							href="https://www.hankyung.com/help/notice?page=5">5</a> <a
							href="https://www.hankyung.com/help/notice?page=5"
							class="btn-page-next"> <span class="blind">다음</span>
						</a> <a href="https://www.hankyung.com/help/notice?page=5"
							class="btn-page-last"> <span class="blind">마지막</span>
						</a>
					</div>
				</section>
			</div>
		</div>
		<!-- // contents -->
		<!-- // contents -->
		<jsp:include page="../include/footer.jsp"/>

	</div>
    </body>
</html>