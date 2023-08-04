package _9.ServletContext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex1/_9.context/context")
public class RedirectServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RedirectServlet2() {
        super();
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   					throws ServletException, IOException {
	   String value = request.getParameter("food");
	   request.setAttribute("food", value); //request 객체에 저장합니다.		   
	   
	   
	   HttpSession session = request.getSession();
	   session.setAttribute("food", value); //session 객체에 저장합니다.	
	   
		/*
		 웹 애플리케이션이 서비스되고 있는 동안 유지하는 것을 의미합니다.
		 생명주기가 웹 애플리케이션과 같은 객체는 ServletContext 입니다.
		 ServletContext는 웹 애플리케이션 서비스가 시작될 때 생성되고 종료될 때 소멸합니다.
		 */
		ServletContext sc = request.getSession().getServletContext();
		sc.setAttribute("food", value);
		
		response.sendRedirect("scope.jsp");
	}

}
