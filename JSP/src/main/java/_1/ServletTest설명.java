/*
 	사용할 클래스들을 import 합니다
 -  서블릿을 생성할 때는 javax.servlet.* 와  javax.servlet.http.*는 반드시 import 해주어야 합니다.
 -  서블릿에 관한 클래스는 javax.servlet 패키지에 포함되어 있고
 	http 요청을 처리하는 클래스들은 javax.servlet.http에 속해 있기 때문입니다.
 */

package _1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Calendar;
/*
 	서블릿을 정의합니다.
 -  서블릿 클래스를 정의하려면 반드시 HttpServlet클래스를 상속받습니다.
 -  HttpServlet클래스에 서블릿에 관한 일반적인 기능이 정의되어 있기 때문에
    HttpServlet클래스를 상속 받은 자식 클래스 또한 서블릿 클래스가 됩니다.	
 */
 
//@WebServlet(urlPatterns = { "/currentTime" })
public class ServletTest설명 extends javax.servlet.http.HttpServlet {
	//doGet메소드를 정의하는 부분입니다.
	//클라이언트에서 요청이 GET방식으로 전송되어 오면 doGet메서드가 자동 실행되게 됩니다.
	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) throws IOException {
		
		// Java Servlet에서 HTTP 응답 헤더의 Content-Type 값을 설정하는 코드입니다.
		//응답 데이터의 MIME 타입을 HTML타입의 text로 지정합니다.
		response.setContentType("text/html");

		//응답 타입의 문자 인코딩 타입을 한글이 제대로 출력되도록 "euc-kr"로 지정합니다.
		response.setCharacterEncoding("euc-kr");
		
		//위 두 문장을 한 번에 작성하면 다음과 같습니다.
		//response.setContentType("text/html;charset=euc-kr");
		
		//Calendar객체를 생성하여 객체로 부터 시간, 분, 초 값을 얻어옵니다.
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY); //시간
		int minute = c.get(Calendar.MINUTE);	//분
		int second = c.get(Calendar.SECOND);	//초
		
		//
		PrintWriter out = response.getWriter();
		out.write("<HTML><HEAD><TITLE>ServletTest</TITLE></HEAD>");
		out.write("<BODY><H1>");
		out.write("현재시각은 ");
		out.write(Integer.toString(hour));
		out.write("시 ");
		out.write(Integer.toString(minute));
		out.write("분 ");
		out.write(Integer.toString(second));
		out.write("초입니다.");
		out.write("</H1></BODY></HTML>");
		out.close();
	}

}
