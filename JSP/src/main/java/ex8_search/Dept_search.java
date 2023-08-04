package ex8_search;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept_search")
public class Dept_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
					  HttpServletResponse response)
				throws ServletException, IOException {

		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("/ex8_db/_3.search/input.jsp");// View
		dispatcher.forward(request, response);
	}
}
