package ex2_insert_gson_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;



@WebServlet("/product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html;charset=utf-8");
		
		DAO dao = new DAO();
		JsonArray array = dao.getList();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(array);
		System.out.println(array);
	} //doGet end
	
	//삽입
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			DTO vo = new DTO();
			vo.setName(request.getParameter("name"));
			vo.setPrice(Integer.parseInt(request.getParameter("price")));
			vo.setMaker(request.getParameter("maker"));
			DAO dao = new DAO();
			int result = dao.insert(vo);
			if (result==1) {
				System.out.println("삽입 성공");
			} else {
				System.out.println("삽입 실패");
			}
			
			doGet(request, response);
		}//doPost end
} //class end
