package _6.getJSON;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get_name")
public class Get_name extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/json;charset=utf-8");
		String dbq = "\"";// "
		// {"name":"홍길동"}
		String Message = "{" + dbq + "name" + dbq + ":" + dbq + "홍길동" + dbq + "}";
		// String Message = "{name:" dbq + "홍길동" + dbq + "}"; //{name:"홍길동"} => error
		// status
		System.out.println(Message);
		response.getWriter().print(Message);
	}
}
