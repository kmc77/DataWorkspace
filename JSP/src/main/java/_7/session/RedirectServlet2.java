package _7.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex1/_7.session/SessionServlet")
public class RedirectServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RedirectServlet2() {
        super();
    }
    
    /* Redirect 방식 : 포워딩될 때 브라우저의 주소 표시줄의 URL이 변경되므로 요청이 바뀌게 됩니다.
       포워딩된 jsp페이지에서는 서블릿에서 request 영역의 공유한 속성 값에 접근할 수 없습니다.
     */
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   					throws ServletException, IOException {
	   //request.getSession() : 세션 객체를 가져 옵니다.
	   HttpSession session = request.getSession();
	   
	   
	   String value = request.getParameter("food");
	   request.setAttribute("food", value); //request 객체에 저장합니다.		   
	   session.setAttribute("food", value); //session 객체에 저장합니다.	
	   
		
		// 이동합니다.
		response.sendRedirect("redirect.jsp");
	}

}
