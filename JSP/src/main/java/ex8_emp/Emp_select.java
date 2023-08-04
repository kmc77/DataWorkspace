package ex8_emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp_select" )
public class Emp_select extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request,
					  HttpServletResponse response)
				throws ServletException, IOException {

		DAO dao = new DAO();
		ArrayList<Emp> list = dao.selectAll();
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("/ex8_db/_2.list.emp/list.jsp");// View
		request.setAttribute("list", list);
		dispatcher.forward(request, response);
	}
}
