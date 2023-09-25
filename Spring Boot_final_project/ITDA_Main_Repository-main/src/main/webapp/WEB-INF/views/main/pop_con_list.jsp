<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="popular-list-view-wrap">
    <div class="popular-list-area">
        <div class="popular-list-top">
            <span class="pop-top-text"><sapn class="pop-hash">#</sapn> 신규 콘텐츠</span>
            <p class="pop-top-sub">새롭게 작성된 신규 콘텐츠를 만나보세요.</p>
        </div>
        <div class="popular-list-bar">
            <button class="contents_category btn bt-item bt-hover bt-2  on" id="0"><span>전체</span>
            </button>
            <t:forEach var="c" items="${channelCategory}">
                <t:set var="categoryLength" value="${fn:length(c.categoryName)}" />
                <button class="contents_category btn bt-item bt-hover bt-${categoryLength}" id="${c.categoryId}">${c.categoryName}
                </button>
            </t:forEach>
        </div>
        <div class="popular-list-cards">
            <ul class="popular-list-ul" style=" display: flex; width: 1080px; flex-wrap: wrap; padding: 0">
            </ul>
        </div>
    </div>
    <div class="loading">
        <div class="loader" style="display:flex; justify-content:center;">
            <div class="dot"></div>
        </div>
        <br>
    </div>
</div>
</body>
</html>
