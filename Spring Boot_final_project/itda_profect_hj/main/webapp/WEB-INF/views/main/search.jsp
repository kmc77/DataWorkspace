<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="ko" data-useragent="Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36"><head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="description" content="네이버 프리미엄 콘텐츠의 채널 및 콘텐츠 검색 결과를 확인할 수 있습니다.">
	<meta property="og:title" content="채널 및 콘텐츠 검색 : 네이버 프리미엄 콘텐츠">
	<meta property="og:image" content="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2022/12/08/og.jpg">
	<meta property="og:description" content="네이버 프리미엄 콘텐츠의 채널 및 콘텐츠 검색 결과를 확인할 수 있습니다.">
	<meta name="twitter:card" content="summary">
	<meta name="twitter:title" content="채널 및 콘텐츠 검색 : 네이버 프리미엄 콘텐츠">
	<meta name="twitter:site" content="프리미엄콘텐츠">
	<meta name="twitter:image" content="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2022/12/08/og.jpg">
	<meta name="twitter:description" content="네이버 프리미엄 콘텐츠의 채널 및 콘텐츠 검색 결과를 확인할 수 있습니다.">
	<title>채널 및 콘텐츠 검색 : 네이버 프리미엄 콘텐츠</title>
		<link rel="stylesheet" href="https://static-nnews.pstatic.net/css/min/20230914a/premium_service.css">
	<link rel="shortcut icon" type="image/x-icon" href="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2021/04/22/favicon_M.ico">
	<link rel="apple-touch-icon-precomposed" size="72x72" href="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2021/04/22/og.png">
	<link rel="apple-touch-icon-precomposed" size="96x96" href="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2021/04/22/og.png">
	<link rel="apple-touch-icon-precomposed" size="144x144" href="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2021/04/22/og.png">
	<link rel="apple-touch-icon-precomposed" size="192x192" href="https://ssl.pstatic.net/static.news/image/news/premium/studio/meta/2021/04/22/og.png">
	<base target="_parent">
	<script async="" src="https://ntm.pstatic.net/ex/nlog.js"></script><script async="" src="https://ntm.pstatic.net/scripts/ntm_774a0c8e7c40.js"></script><script>
		var g_ssc = nsc = "Mpremiumcontents.all";
		var g_default_area = "art";

		var svr = "one-service-premium-r-20230914-230914-164253-6d7db59565-l82xv";
		var nelo = {
			sampleNumber : 100,
			maxCount : 100,
			maxSendMessage : "로그 전송 최대치 도달"
		};

		var isGreendot = document.cookie.indexOf("MM_NEW=1") > -1;

		var domain = "https://contents.premium.naver.com";
		var ajaxDomain = "";
		var MEDIA_GW_DOMAIN = "https://media-gw.naver.com";
		var PREMIUM_GW_DOMAIN = "https://premium-gw.naver.com";
		var PREMIUM_LOG_DOMAIN = "https://l.premium.naver.com";
		var urlPrefix = "";
		var newsDomain = "";
		var layoutName = "channel_search";

		var unitIds = [];
		var divIds = [];
		var ArticleAd = {};

		var _paq = window._paq = window._paq || [];
		_paq.push(["setDocumentTitle", layoutName + " / " + document.title]);
		_paq.push(["trackPageView"]);
		_paq.push(["enableLinkTracking"]);
		_paq.push(["setTrackerUrl", PREMIUM_LOG_DOMAIN + "/matomo"]);
		_paq.push(["setSiteId", "1"]);

		var isPremiumReferer = false;
		isPremiumReferer = true;
	</script>
	<script src="https://static-nnews.pstatic.net/js/min/20230914a/premium_common.min.js"></script>
<style>.osSwitch{position:relative;display:inline-block;width:34px;height:15.3px}.osSwitch input{opacity:0;width:0;height:0}.osSlider{position:absolute;top:0;left:0;right:0;bottom:0;border-radius:34px;background-color:#93a0b5;transition:0.4s}.osSlider:before{position:absolute;content:'';height:13px;width:13px;left:2px;bottom:1px;border-radius:50%;background-color:white;transition:0.4s}input:checked+.sliderGreen{background-color:#04d289}input:checked+.sliderRed{background-color:#ff3b30}input:not(:checked)+.defaultGreen{background-color:#04d289}input:checked+.osSlider:before{transform:translateX(17px)}
</style><style>
    @font-face {
      font-family: 'SegoeUI_online_security'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui.woff);
    }

    @font-face {
      font-family: 'SegoeUI_bold_online_security'; 
      src: url(chrome-extension://llbcnfanfmjhpedaedhbcnpgeepdnnok/segoe-ui-bold.woff);
    }
</style></head>
<body class="">
<div class="u_skip"><a href="#ct">본문 바로가기</a></div>
<div id="_CONTENT_INDICATOR_WRAP" style="display:none;">
	<label for="_CONTENT_INDICATOR" class="blind">페이지 스크롤 진행률</label>
	<progress id="_CONTENT_INDICATOR" class="progress" max="100" value="0"></progress>
</div>
<hr>
<script>
	var svt = "20230919175006.941";
	var timestamp = svt.substr(0, 8);
	var isLogin = false;

	var service = {
		premium: true
	};

	var analyticsNtmUrl = "https://ntm.pstatic.net/scripts/ntm_774a0c8e7c40.js";

	var envPhase = "production";
	var isProduction = true;
</script>
<div id="ct_wrap" class="container">
	<div id="ct" class="container_inner">
		<div class="container_main">
			<div class="container_sidebar _CONTAINER_SIDEBAR">
				<div class="container_sidebar_inner _GRID_TEMPLATE_COLUMN_SIDEBAR _CONTAINER_SIDEBAR_INNER"></div>
			</div>
			<div class="container_content _GRID_TEMPLATE_COLUMN _STICKY_CONTENT">
			<div class="premium_search_page">
	<div class="psp_main">
		<div class="psp_head">
			<div class="psp_head_inner">
				<div class="psp_head_content">
			<a href="#" class="psp_back_button _BACK" data-clk="pch_search.back"><span class="blind">뒤로가기</span></a>
			<div class="psp_input_wrap _SEARCH_INPUT_WRAP non_searching">
				<input id="_SEARCH_INPUT" type="text" placeholder="프리미엄 채널, 콘텐츠를 검색해 보세요" class="psp_search_input" value="" data-url="/ch/search" data-search-query="" autocomplete="off">
				<button id="_SEARCH_RESET_BTN" type="button" class="psp_input_cancel_button" data-clk="pch_search.close">삭제</button>
			</div>
			<button type="button" class="psp_search_button _SEARCH_SUBMIT_BTN" data-clk="pch_search.search" data-url="/ch/search" data-search-value="true"><span class="blind">검색</span></button>
				</div>
			</div>
		</div>
		<div class="psp_recent _SEARCH_HISTORY_AREA">
			<strong class="psp_recent_title">최근 검색어</strong>
			<div class="psp_recent_list_area">
				<div id="_SEARCH_HISTORY_LIST_WRAP" data-nclk-prefix="pch_search">
				<div class="psp_recent_text">검색어 저장 기능이 꺼져 있습니다.</div>
				</div>
				<script type="x-tmpl-mustache" class="_SEARCH_HISTORY_LIST">
				{{#autoSave}}
				{{#hasKeywords}}
				<ul class="psp_recent_list">
					{{#keywords}}
					<li class="psp_recent_item">
						<a href="#" class="psp_recent_link _SEARCH_KEYWORD_LINK" data-keyword="{{keyword}}" data-clk="{{nclkPrefix}}.historylink">{{keyword}}</a>
						<button type="button" class="psp_recent_delete _DELETE_SEARCH_HISTORY_BTN" data-keyword="{{keyword}}" data-clk="{{nclkPrefix}}.historyremove"><span class="blind">삭제</span></button>
					</li>
					{{/keywords}}
				</ul>
				{{/hasKeywords}}
				{{^keywords}}
				<div class="psp_recent_text">검색 내역이 없습니다.</div>
				{{/keywords}}
				{{/autoSave}}
				{{^autoSave}}
				<div class="psp_recent_text">검색어 저장 기능이 꺼져 있습니다.</div>
				{{/autoSave}}
				</script>
			</div>
			<div class="psp_recent_option">
				<div class="psp_recent_option_button_wrap">
					<button type="button" class="psp_recent_option_button _CLEAR_SEARCH_HISTORY_BTN" data-clk="pch_search.historyclear" style="display: none;">전체 삭제</button>
					<button type="button" class="psp_recent_option_button _AUTO_SAVE_BUTTON" data-enable="false" data-clk="pch_search.historyoff" style="display: none;">자동저장 끄기</button>
					<button type="button" style="" class="psp_recent_option_button _AUTO_SAVE_BUTTON" data-enable="true" data-clk="pch_search.historyon">자동저장 켜기</button>
				</div>
				<div class="psp_recent_option_close_wrap">
					<button type="button" class="psp_recent_option_button _CLOSE_SEARCH_HISTORY_BTN" data-clk="pch_search.historyclose">닫기</button>
				</div>
			</div>
		</div>
		<div class="_TOP_SEARCH_KEYWORD">
			<div class="premiumhome_keyword _TEMPLATE" data-template-id="SCS_PREMIUM_HOME_TOP_SEARCH_KEYWORD">
				<h2 class="pk_h">인기검색어</h2>
				<ul class="pk_list">
					<li class="pk_item">
						<a href="/ch/search?searchQuery=%EC%9E%90%EC%9C%A8%EC%A3%BC%ED%96%89" class="pk_link" data-clk="pch_search.hot">1</a>
					</li>
					<li class="pk_item">
						<a href="/ch/search?searchQuery=%EC%88%98%ED%95%99" class="pk_link" data-clk="pch_search.hot">2</a>
					</li>
					<li class="pk_item">
						<a href="/ch/search?searchQuery=%ED%8C%A1%ED%81%B4%EB%9E%98%EC%8A%A4" class="pk_link" data-clk="pch_search.hot">3</a>
					</li>
					<li class="pk_item">
						<a href="/ch/search?searchQuery=%EC%98%81%EC%96%B4" class="pk_link" data-clk="pch_search.hot">4</a>
					</li>
					<li class="pk_item">
						<a href="/ch/search?searchQuery=%EC%B2%AD%EC%86%A1%EC%B4%8C%EB%86%88" class="pk_link" data-clk="pch_search.hot">5</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

			</div>
			<div class="container_aside _CONTAINER_ASIDE">
				<div class="container_aside_inner _GRID_TEMPLATE_COLUMN_ASIDE _CONTAINER_ASIDE_INNER"></div>
			</div>
		</div>
		<div class="_GRID_TEMPLATE_COLUMN_OUTSIDE"></div>
	</div>
</div>
<div id="frontDetect"></div>
<div id="_LAYER_DIMMED" class="layer_dimmed" style="display:none;"></div>
<div id="_MODAL_WRAP"></div>
<script type="x-tmpl-mustache" class="_MODAL_TEMPLATE">
<div class="popup_layer{{#isClose}} as_close_button{{/isClose}}{{#popupClass}} {{popupClass}}{{/popupClass}} _MODAL">
	{{#description}}
	<strong class="popup_tit">{{{title}}}</strong>
	<p class="popup_sub_desc">{{{description}}}</p>
	{{/description}}
	{{^description}}
	{{#itemList.length}}
	<strong class="popup_tit">{{{title}}}</strong>
	<dl class="popup_dl">
		{{#itemList}}
		<div class="popup_description_wrap">
			<dt class="popup_dt">{{{key}}}</dt>
			<dd class="popup_dd">{{{value}}}</dd>
		</div>
		{{/itemList}}
	</dl>
	{{/itemList.length}}
	{{^itemList.length}}
	<p class="popup_desc">{{{title}}}</p>
	{{/itemList.length}}
	{{/description}}
	{{#linkButtonList.length}}
	<div class="popup_link_wrap">
		{{#linkButtonList}}
		<a href="{{url}}" class="popup_link">
			<div class="popup_link_text">{{{title}}}</div>
			{{#description}}
			<div class="popup_link_desc">{{{description}}}</div>
			{{/description}}
		</a>
		{{/linkButtonList}}
	</div>
	{{/linkButtonList.length}}
	{{#isClose}}
	<button type="button" class="popup_close_button _MODAL_CANCEL"><i class="icon_close">닫기</i></button>
	{{/isClose}}
	{{^isHiddenConfirm}}
	<div class="popup_button_wrap">
		{{#isCancel}}
		<button type="button" class="button_layer _MODAL_CANCEL">
			{{cancelMessage}}
		</button>
		{{/isCancel}}
		<button type="button" class="button_layer type_confirm _MODAL_CONFIRM">
			{{confirmMessage}}
		</button>
	</div>
	{{/isHiddenConfirm}}
</div>
</script>
<div id="_TOAST_WRAP"></div>
<script type="x-tmpl-mustache" class="_TOAST_TEMPLATE">
<div class="toast_popup_layer">
	<p class="toast_popup_desc">{{{text}}}</p>
</div>
</script>
	<script src="https://static-nnews.pstatic.net/js/min/20230914a/premium_library.min.js"></script>
	<script src="https://static-nnews.pstatic.net/js/min/20230914a/premium_read.min.js"></script>
<script>
$(window).on("load", function() {
	var $content = $("#_SE_VIEWER_CONTENT, ._VOD_PLAYER_WRAP");

	if ($content.length > 0 && $content.hasClass("_NIL_SEND") === true) {
		window.ntm = window.ntm || [];

		var ntmOption = {};


		var cpName = $content.data("cp-name");
		var subId = $content.data("sub-id");
		var contentId = $content.data("content-id");
		var contentAuth = $content.data("content-auth");
		var isMembership = $content.data("is-membership");
		var isPromotion = $content.data("is-promotion");
		var isPreview = $content.data("is-preview");
		var partnerChannel = $content.data("partner-channel");
		var partnerType = $content.data("partner-type");
		var type = $content.data("type");
		var subType = $content.data("sub-type");
		var userType = 0;

		if (contentAuth === true) {
			userType = 1;
		}

		var source = "";
		var sourceId = "";

		ntmOption["hitType"] = "cv";
		ntmOption["eventCategory"] = "post_view";

		ntmOption["channelId"] = cpName + "_" + subId;
		ntmOption["uri"] = "https://contents.premium.naver.com/" + cpName + "/" + subId + "/contents/" + contentId;
		ntmOption["userType"] = userType;
		ntmOption["dimension1"] = cpName;
		ntmOption["dimension2"] = isMembership == true ? "original" : "preview";
		if (isPromotion == true) {
			ntmOption["dimension3"] = "free";
		}

		if (source) {
			ntmOption["dimension4"] = source;

			if (sourceId) {
				ntmOption["dimension5"] = sourceId;
			}
		}

		if (partnerChannel) {
			ntmOption["dimension6"] = partnerChannel === "Y" ? "partner" : "premium";
		}

		if (partnerType) {
			ntmOption["dimension7"] = partnerType.toLowerCase();
		}

		if ("VIDEO" === subType) {
			ntmOption["dimension8"] = "video";
		}

		if (!!!isPreview) {
			ntm.push({
				event: "nilSend",
				ni: ntmOption
			});

			var eventType = "onpagehide" in window ? "pagehide" : "beforeunload";
			$(window).on(eventType, function() {
				ntmOption["hitType"] = "event";
				ntmOption["eventCategory"] = "action";
				ntmOption["eventAction"] = "leave";

				ntm.push({
					event: "nilSend",
					ni: ntmOption
				});
			});

		}
	}
});
</script>


<script>
var eventType = "onpageshow" in window ? "pageshow" : "load";
$(window).on(eventType, function() {
	var additionalInfo = {};

	var sti = "";
	if (sti) {
		additionalInfo["sti"] = sti;
	}

	var $content = $("#_SE_VIEWER_CONTENT, ._VOD_PLAYER_WRAP");

	var gdid = $content.data("gdid");
	if (gdid) {
		window.lcsResult = lcs_do_gdid(gdid, additionalInfo);
	} else {
		window.lcsResult = lcs_do(additionalInfo);
	}
});
</script>

</body></html>