<%--
JSP 표준 태그 라이브러리 (JSTL)
- 개발자가 자주 사용하는 기능을 모아놓은 사용자 정의 태그(태그 라이브러리)입니다.

JSTL 다운로드
1) https://mvnrepository.com/ 접속
   "jstl" 검색
   
   https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
   jstl-1.2.jar 다운로드
   
2) 이클립스에 파일 넣기
   webapp/WEB-INF/lib/(jstl-1.2.jar)
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%-- * taglib 디렉티브: JSTL이나 JSP 사용자 정의 태그 등 태그 라이브러리 사용 시 접두어를 지정하는 데 사용합니다.
     1. prefix 속성: 사용할 사용자 정의 태그의 네임스페이스를 지정하며,
        지정한 값은 해당 태그 라이브러리를 호출할 때 사용할 접두어를 의미합니다.
        
     2. uri 속성: 태그와 속성 정보가 정의된 파일이 위치한 위치를 지정합니다.
     
     * taglib 프로스: 코드 길이를 줄이고 가독성을 향상시킵니다.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
 <%--
    prefix="f": 사용할 태그의 네임스페이스 이름입니다.
    예) <네임스페이스:태그이름/>
    <f:set/>
    
    uri="http://java.sun.com/jsp/jstl/core"
          core 라이브러리를 사용하겠다는 의미입니다.
          고정 주소이며 반드시 작성되어야 합니다.
--%>
<html>
<head>
<title>JSTL core 라이브러리 사용 예제 2</title>
</head>
<body>
   <%-- 
   		* Cross-Site Scription(XSS)
   		  악의적으로 사용자가 공격하려는 사이트에 스크립트를 넣는 기법이며
   		  공격에 성공하면 사이트에 접속한 사용자는 삽입된 코드를 실행하게 되면서 의도치 않은 행동을 수행시킵니다.
   
    --%>
   <c:set var="test" value="<script>alert('환영합니다-escapeXml=false')</script>" />
   <c:out value="${test }" escapeXml="false"/>
   <%--
   	escapeXml=false는 html태그를 인식합니다.
   	페이지 소스 보기 : <script>alert('환영합니다.-escapeXml=false')</script>
   	실행 결과 : 스크립트 실행
    --%>
   </body>
   </html>