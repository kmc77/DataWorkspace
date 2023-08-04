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
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
 
 
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
<title>JSTL core 라이브러리 사용 예제 1</title>
</head>
<body>
   <%-- <f:set>: 값을 변수에 저장하는 태그입니다.
        var: 저장할 변수의 이름
        value: 저장할 값
    --%>
   <f:set var="test" value="Hello JSTL!"/>
   <h3>
      <f:out value='${test}'/> <!-- 이 태그는 저장된 값을 출력합니다. -->
   </h3>
   
   <h3>
      <f:out value='test'/> <!-- 이 태그는 저장된 값을 출력합니다. -->
   </h3>
   
   <f:remove var="test" /> <!-- 이 태그는 "test"라는 이름의 변수를 제거합니다. -->
   <h3>
      <f:out value="${test}"/>
   </h3>
   
   <f:catch var="err"> <!-- 예외 처리를 위한 태그입니다.
    예외가 발생하면 var로 지정한 예외 객체가 할당됩니다. -->
      <%=10 / 0%>
   </f:catch>
   <h3>
      <f:out value="${err}"/>
   </h3>
   
   <!-- 조건 처리를 위한 태그입니다. if와 유사하지만 else를 지원하지 않습니다. -->
   <f:if test="true">
      true 다음에 공백이 들어가면 출력되지 않습니다. - 조건식이 true이므로 무조건 실행됩니다.<br>
   </f:if>
   
   <f:if test="${5<10}">
      <h3>5는 10보다 작습니다.</h3>
   </f:if>
   
   <f:if test="${6+3==9}">
      <h3>6 + 3은 9입니다.</h3>
   </f:if>
   
   <%--
   1. <f:choose>, <f:when>, <f:otherwise> 태그
   - 여러 개의 조건 절이 있는 경우 사용합니다.
   
   - 조건 중 하나라도 만족하면 해당 부분을 실행하고 탈출합니다.
   (즉, 하나만 실행되며 if-else if-else 구문과 유사합니다)
   한 개의 choose 태그 안에 여러 개의 when 태그가 존재합니다.
   
   2. 사용법 예
   <f:choose>
   
   <f:when test="testCondition"> <!-- 조건이 만족되면 실행 - 여러 개를 작성할 수 있습니다. -->
   ~
   </f:when>
   
   <f:when test="testCondition">
   ~
   </f:when>
   
   <f:otherwise> <!-- 조건이 만족되지 않으면 실행 -->
   ~
   </f:otherwise>
   
   </f:choose>
   --%>
   <f:choose>
      <f:when test="${5+10==50}">
         <h3>5+10은 50과 같습니다.</h3>
      </f:when>
      <f:otherwise>
         <h3>5+10은 50과 같지 않습니다.</h3>
      </f:otherwise>
   </f:choose>

   <f:set var="a" value="3" />

   <f:choose>
      <f:when test="${a == 1}">
         <h3>1.</h3>
      </f:when>
      <f:when test="${a == 2}">
         <h3>2.</h3>
      </f:when>
      <f:otherwise>
         <h3>1도 2도 아닙니다.</h3>
      </f:otherwise>
   </f:choose>

   <f:set var="a" value="${a + 1}" />

   <h3>
      <f:out value="${a}"/>
   </h3>
</body>
</html>
