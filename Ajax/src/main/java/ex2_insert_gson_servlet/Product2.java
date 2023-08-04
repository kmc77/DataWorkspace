package ex2_insert_gson_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;



@WebServlet("/product2")
public class Product2 extends HttpServlet {
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

    // 삭제, 추가, 수정
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int result = -1;
        DAO dao = new DAO();
        String label = request.getParameter("label");
        switch (label) {
        case "삭제":
            int idToDelete = Integer.parseInt(request.getParameter("id"));
            result = dao.delete(idToDelete);
            break;
            
            case "추가":
            case "수정완료":
            	DTO vo = new DTO();
                vo.setName(request.getParameter("name"));
                vo.setPrice(Integer.parseInt(request.getParameter("price")));
                vo.setMaker(request.getParameter("maker"));
                if (label.equals("수정완료")) {
                    vo.setId(Integer.parseInt(request.getParameter("id")));
                    result = dao.update(vo);
                } else {
                    result = dao.insert(vo);
                }
        }
        // result=0; // 실패 화면 보기 위한 값
        if (result == 1) {
            System.out.println(label + " 성공");
            doGet(request, response);
        } else {
            System.out.println(label + " 실패");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(label + " 실패");
        }
    }
}
