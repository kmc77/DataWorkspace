<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%-- 웹앱 폴더 아래에 "upload" 폴더를 생성하고 실행하세요. --%>
<%@ page language="java" import="com.oreilly.servlet.MultipartRequest" %>

<%-- 파일 업로드를 위한 MultipartRequest 객체를 가져옵니다. --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%-- 중복 파일 이름을 처리하기 위한 DefaultFileRenamePolicy 객체를 가져옵니다. --%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%
String uploadPath = application.getRealPath("upload");
out.print("upload 경로: " + uploadPath);
	
	int size = 10*1024*1024; //파일 최대 크기를 10MB로 지정합니다.
	String name = "";
	String subject = "";
	String systemName1 = "";
	String systemName2 = "";
	String origfileName1 = "";
	String origfileName2 = "";
	
	try{
		/* 업로드를 담당하는 부분입니다.
		1. 첫 번째 인자(request) : 폼에서 가져온 값을 얻기 위해 request객체를 전달해 줍니다.
		2. 두 번째 인자(uploadPath) : 업로드될 파일의 위치 입니다.
		3. 세 번째 인자(size) : 업로드 할 크기이며 지정 크기보다 크면 Exception발생합니다.
		4. 네 번째 인자("euc-kr") : 파일 이름이 한글인 경우 처리하는 부분입니다.
		5. 다섯 번째 인자 : 똑같은 파일을 업로드 할 경우 중복되지 않도록 자동으로 파일이름을 변환해주는 기능을 합니다.
		
		*/
		 MultipartRequest multi = new MultipartRequest(request,
                 uploadPath,
                 size,
                 "euc-kr",
                 new DefaultFileRenamePolicy());
		
	  name = multi.getParameter("name");
	    subject = multi.getParameter("subject");

	    // name=fileName1 입력 값으로 업로드된 파일의 시스템 파일 이름을 가져옵니다.
	    // 중복 파일 이름인 경우 파일 이름 뒤에 번호를 추가하여 처리합니다.
	    systemName1 = multi.getFilesystemName("fileName1");

	    // name=fileName1 입력 값으로 업로드된 파일의 원본 파일 이름을 가져옵니다.
	    origfileName1 = multi.getOriginalFileName("fileName1");

	    systemName2 = multi.getFilesystemName("fileName2");
	    origfileName2 = multi.getOriginalFileName("fileName2");

	} catch(Exception e) {
	    e.printStackTrace();
	    out.print("에러 입니다.");
	}
	%>
<html>
<head>
 <title> 파일 업로드 </title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<form name="filecheck" action="fileCheck2.jsp" method="post">
		<input type="hidden" name="name" 		value="<%=name %>">
		<input type="hidden" name="subject" 		value="<%=subject %>">
		
		<input type="hidden" name="systemName1" 	value="<%=systemName1 %>">
		<input type="hidden" name="systemName2" 	value="<%=systemName2 %>">
		
		<input type="hidden" name="origfileName1"	value="<%=origfileName1 %>">
		<input type="hidden" name="origfileName2"	value="<%=origfileName2 %>">
		<input type="hidden" name="uploadPath" 		value="<%=uploadPath %>">
		<input type="submit" value="업로드 확인 및 다운로드 페이지 이동" 		class="btn btn-info">
		</form>
</div>
</body>
</html>	

