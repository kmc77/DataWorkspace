<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="resources/css/premium_service2.css">
<meta charset="UTF-8">
<link rel="shortcut icon" type="image" href="resources/image/main/tv_icon.ico" />
<title>잇:다</title>
</head>
<body>
<header class="header_wrap as_home">
	<div class="header">
		<div class="header_inner">
			<div class="header_content">
				<div class="header_service">
					<h1 class="header_logo">
						<a href="/" class="header_logo" ><img class="header_logo_img" alt="" src="resources/image/common/itda_logo3.png" ><span class="blind">잇:다</span></a>
					</h1>
				</div>
				<div class="header_menu">
					<a class="header_search" onclick="location.href='${pageContext.request.contextPath}/main/search'"></a>
					
					
					<div class="header_user">
						<button type="button" class="user_link" data-toggle="modal" data-target="#myModal">
							<div class="user_sign_in">로그인</div>
						</button>
					</div>
					
						<!-- Modal -->
				<form id="modalForm"
					action="${pageContext.request.contextPath}/member/loginProcess"
					method="post">

					<div class="modal fade" id="myModal">
						<div class="modal-dialog">
							<div class="modal-content">
									<div class="modal-content">
									<!-- 병합 -->
										<div class="modal-header2">
											<h2>로그인</h2>
										</div>
										<article class="modal_article login p_lr_space pb24">
											<button class="close" data-dismiss="modal" aria-label="Close"
												data-toggle="tooltip" data-placement="bottom"
												data-original-title="닫기">
												<i class="btl bt-times"></i>
											</button>


											<form action="/backpg/login.cm" method="post"
												target="hidden_frame">
												<input type="hidden" name="back_url" value="Lw%3D%3D">
												<input type="hidden" name="back_url_auth" value="">
												<input type="hidden" name="used_login_btn" value="Y">

												<div class="input_block">
													<div class="input_form">
														<input title="이메일" type="text" name="uid" value=""
															placeholder="이메일"><i aria-hidden="true"
															class="zmdi zmdi-check"></i>
													</div>
													<div class="input_form brt">
														<input title="비밀번호" name="passwd" type="password" value=""
															placeholder="비밀번호" autocomplete="off"><i
															aria-hidden="true" class="zmdi zmdi-check"></i>
													</div>
												</div>
												<!--input_form에 active클래스명이 붙으면 (인풋에 글자가 입력된 상태) 체크표시 활성화 -->

												<div class="cheak_article">
													<div class="checkbox checkbox-styled">
														<label class="form-label"><div class="logincheckbox"> <input type="checkbox" 
															class="ie" name="auto_login" data-type="use" value="ok"
															> </div> <div class="loginkeep"><span class="agree_tit">로그인상태유지</span></div>
														</label>
													</div>
												</div>

												<p>
													<button class="btn btn-primary btn-block"
														style="font-size: 14px;">로그인</button>
												</p>
											</form>

											<div class="over_h">
												<div style="float:left;"> <a href="javascript:;"
													onclick="SITE_MEMBER.openJoinPatternChoice('Lw%3D%3D', '');"
													class="float_l">회원가입</a></div> <div style="text-align:right"> <a href="javascript:;" 
													onclick="SITE_MEMBER.openFindPassword('L2RpYWxvZy9sb2dpbi5jbQ%3D%3D');"
													class="float_r">아이디 · 비밀번호 찾기</a></div>
											</div>


											<div class="divider txt_c">
												<div class="border"></div>
												<p style="text-align:center; margin-bottom:2px;" >또는</p>
												<div class="border right"></div>
											</div>
											<div class="sns_login_form">
												<p class="txt_c mb10">
													<div><a  class="btn btn-naver !tw-block"
														href="https://nid.naver.com/oauth2.0/authorize?response_type=code&amp;svctype=0&amp;redirect_uri=https%3A%2F%2Fthepicq.com%2Foauth&amp;client_id=54P4N7kqyLdRMnKcnht5&amp;state=Lw%253D%253D%7Cnaver%7CY%7C%7C">네이버로
														시작하기</a></div>
												</p>
												<p class="txt_c mb10">
													<a class="btn btn-kakao !tw-block" id="custom-login-btn"
														href="https://kauth.kakao.com/oauth/authorize?response_type=code&amp;redirect_uri=https%3A%2F%2Fthepicq.com%2Foauth&amp;client_id=414c871f5c6b89877050158f15e84de1&amp;state=Lw%253D%253D%7Ckakao_sync%7CY%7C%7C">카카오로
														시작하기</a>
												</p>
												<p class="txt_c mb10">
													<a class="btn btn-google !tw-block holder"
														href="https://accounts.google.com/o/oauth2/auth?approval_prompt=auto&amp;response_type=code&amp;scope=email+profile&amp;redirect_uri=https%3A%2F%2Fthepicq.com%2Foauth&amp;client_id=89407851314-7i2mdvacndsltvd9279uqqlo0pgr4rsm.apps.googleusercontent.com&amp;state=Lw%253D%253D%7Cgoogle%7CY%7C%7C"><i
														aria-hidden="true" class="social-icon fa fa-google-plus"></i>
														Google로 시작하기</a>
												</p>
											</div>

										
											<script type="text/javascript">
												if (typeof window.sessionStorage !== "undefined") {
													if (typeof SITE_SHOP_DETAIL != "undefined") {
														if (SITE_SHOP_DETAIL
																.getCurrentProdNo()) {
															SITE_SHOP_DETAIL
																	.saveSelectedProd();
														} else {
															const itemsToKeep = [
																	'history_reset',
																	'undoList',
																	'redoList' ];
															for ( let key in sessionStorage) {
																if (!itemsToKeep
																		.includes(key)) {
																	sessionStorage
																			.removeItem(key);
																}
															}
														}
													} else {
														const itemsToKeep = [
																'history_reset',
																'undoList',
																'redoList' ];
														for ( let key in sessionStorage) {
															if (!itemsToKeep
																	.includes(key)) {
																sessionStorage
																		.removeItem(key);
															}
														}
													}

													IMWEB_SESSIONSTORAGE
															.clear('PROD_REVIEW_.*');
													IMWEB_SESSIONSTORAGE
															.clear('PROD_QNA_.*');
												}
												
											</script>
											
										</article>
										<!-- 병합-end -->
									</div>
									

								<!-- modal-content end -->
							</div>
							<!-- modal-dialog end -->
						</div>
						</div>
						<!-- Modal end -->
						
						
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}">
				</form>
					
				</div>
			</div>
		</div>
	</div>
</header>
</body>
</html>