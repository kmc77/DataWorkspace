<%--
	JSTL(JSP Standard Tag Library)
	- 자주 사용되는 기능을 모아둔 커스텀 태그(개발자가 직접 정의할 수 있는 태그)입니다.
	
	JSTL 다운로드
	1) ① https://mvnrepository.com/접속
		검색어 "jstl" 입력
		
	   ② https://mvnrepository.com/artifact/javax.servlet/jstl/1.2
	     jstl-1.2.jar 다운로드합니다.
	     
	2) 이클립스에 파일 넣기
	   webapp / WEB-INF / lib / (jstl-1.2.jar)     	
 --%>

<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<%-- * taglib 지시어 : JSTL 이나 커스텀 태그 등 태그 라이브러리를 JSP에서 사용할 때 접두사를 지정하기 위해 사용합니다.

	 ① prefix 속성은 사용할 커스텀 태그의 네임스페이스를 지정하고
	          명시된 값은 태그 라이브러리를 호출할 때 사용할 접두사를 의미합니다.
	          
	 ② uri 속성은 태그 라이브러리에 정의한 태그와 속성 정보를 저장한 파일이 존해하는 위치를 지정합니다.
	 
	 * tahlib 장접 : 사용하면 코드의 길이가 줄어들고 인식성이 좋아집니다.
	          	
 --%>
 <%-- JSP페이지에 core 라이브러리를 등록합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
	prefix="c" : 사용할 태그의 네임스페이스의 이름입니다.
		예) <네임스페이스:태그이름/>
			<c:set/>
			
	uri="http://java.sun.com/jsp/jstl/core"
		코어 라이브러리를 사용하겠다는 의미입니다.
		정해져 있는 주소이며 반드시 적어야 합니다.		
 --%>
<html>
<head>
    <title>JSTL core 라이브러리 사용 예제 1</title>
</head>
<body>
       <%-- <c:set> 변수에 값을 설정하는 태그입니다.
       		var : 값을 저장할 변수 이름
       		value : 저장할 값
        --%>
        <c:set var="test" value="Hello JSTL!" />
  	 
  	 	<h3>
  	 		&lt;c:set&gt; 사용 후 :
  	 		<c:out value='${text}' /><!-- 지정된 값을 출력하는 태그입니다 -->
  	 	</h3>
</body>
</html>
