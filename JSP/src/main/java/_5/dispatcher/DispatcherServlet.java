package _5.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex1/_5.dispatcher/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DispatcherServlet() {
        super();
    }
    
    /* 페이지 이동 방법
     Dispatcher 방식
      - 클라이언트로부터 요청 받은 Servlet 프로그램이 응답을 하지 않고
        다른 서블릿이나 JSP 페이지 등에 요청을 전달합니다. (요청 재지정)
      - 이 방식으로 이동하면 주소 표시줄의 주소가 변경되지 않습니다.
      - request 영역을 공유하게 됩니다.
      - 방법 : RequestDispatcher에서 제공하는 메소드(forward())를 사용하여 요청을 재지정합니다.
     */
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   					throws ServletException, IOException {
	   
	   System.out.println("요청방식 : " + request.getMethod());
	   System.out.println("파라미터 food의 값 : " + request.getParameter("food"));
	   
	   //dispatcher.jsp : 이동할 페이지 주소
	   //http://localhost:8088/JSP/dispatcher.jsp의미
	   //RequestDispatcher dispatcher = request.getRequestDispatcher("/dispatcher.jsp");
	   
	   //http://localhost:8088/JSP/ex1/_5.dispatcher/dispatcher.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher.jsp");
		// 이동합니다.
		dispatcher.forward(request, response);
	}

}
