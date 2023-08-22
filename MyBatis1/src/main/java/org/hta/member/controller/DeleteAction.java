package org.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.dao.MemberDao;

public class DeleteAction implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = request.getParameter("id");
    	MemberDao md = new MemberDao();
    	int result = md.delete(id);
    	
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	if (result == 1) {
    		out.println("<script>");
    		out.println("alert('삭제 성공입니다.');");
    		out.println("location.href='list.net'");
    		out.println("</script>");
    		out.close();
    		
    	} else {
    		out.println("<script>");
    		out.println("alert('삭제 실패입니다.');");
    		out.println("location.href='list.net'");
    		out.println("</script>");
    		out.close();
    	}
        return null;
    }
}