package _1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/currentTime2" })
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response) throws IOException {

		 response.setContentType("text/plain"); //브라우저에게 해당 응답이 텍스트 데이터임을 알려줍니다.
		//response.setContentType("text/html");

		response.setCharacterEncoding("euc-kr");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
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
