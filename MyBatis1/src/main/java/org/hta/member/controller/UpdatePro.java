package org.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

public class UpdatePro implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Member mem = new Member();
    	MemberDao md = new MemberDao();
    	mem.setId(request.getParameter("id"));
    	mem.setPassword(request.getParameter("password"));
    	int result = md.update(mem);
    	
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	if (result == 1) {
    		out.println("<script>");
    		out.println("alert('수정 성공입니다.');");
    		out.println("location.href='list.net'");
    		out.println("</script>");
    		out.close();
    		
    	} else {
    		out.println("<script>");
    		out.println("alert('수정 실패입니다.');");
    		out.println("history.go(-1)");
    		out.println("</script>");
    		out.close();
    	}
        return null;
    }
}