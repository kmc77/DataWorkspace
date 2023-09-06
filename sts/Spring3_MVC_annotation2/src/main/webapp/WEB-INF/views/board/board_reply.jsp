<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="header.jsp" />
<script src="../resources/js/reply.js" charset="utf-8"></script><title>mvc 게시판</title>
<style>
h1 {
	font-size: 1.5rem;
	text-align: center;
	color: #1a92b9
}

.container {
	width: 60%;
}

label {
	font-weight: bold;
}
</style>
</head>
<body>
	<%-- 게시판 답글 --%>
	<div class="container">
		<form action="replyAction" method="post" name="boardform">
			<input type="hidden" name="BOARD_RE_REF" value="${boarddata.BOARD_RE_REF}">
			<input type="hidden" name="BOARD_RE_LEV" value="${boarddata.BOARD_RE_LEV}">
			<input type="hidden" name="BOARD_RE_SEQ" value="${boarddata.BOARD_RE_SEQ}">
			<h1>MVC게시판 - reply</h1>
			<div class="form-group">
				<label for="board_name">글쓴이</label>
				<input name="BOARD_NAME" id="board_name" type="text" class="form-control" value="${id}" readOnly>
			</div>
			<div class="form-group">
				<label for="board_subject">제목</label>
				<textarea name="BOARD_SUBJECT" id="board_subject" rows="1" class="form-control" maxlength="100">Re:${boarddata.BOARD_SUBJECT}
				</textarea>
			</div>
			<div class="form-group">
				<label for="board_content">내용</label>
				<textarea name="BOARD_CONTENT" id="board_content" rows="10" class="form-control"></textarea>
			</div>

			<div class="form-group">
				<label for="board_pass">비밀번호</label>
				<input name="BOARD_PASS" id="board_pass" type="password" class="form-control">
			</div>
			
			<div class="form-group">
				<button type=submit class="btn btn-primary" vlaue="등록">등록</button>
				<button type=reset class="btn btn-danger" onClick="history.go(-1)" value="취소">취소</button>
			</div>
		</form>
	</div>

</body>
</html>