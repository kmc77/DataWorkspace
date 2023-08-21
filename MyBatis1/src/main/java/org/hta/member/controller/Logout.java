package org.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
	HttpSession session = request.getSession();
    	
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	session.invalidate();
    	
    	out.println("<script>");
    	out.println("alert('로그아웃 되었습니다.');");
    	out.println("location.href='loginForm.net'");
    	out.println("</script>");
    	
       
        return null;
    }
}