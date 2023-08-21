package org.hta.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

public class JoinAction implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	Member mem = new Member();
    	mem.setId(id);
    	mem.setPassword(password);
    	
    	int result = 0;
    	MemberDao md = new MemberDao();
    	int chkresult = md.chk(mem);
    	
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	if(chkresult == 0) { //아이디가 없는 경우
    		result = md.insert(mem);
    		if(result > 0) {
    			out.println("<script>");
    			out.println("alert('가입 성공입니다.');");
    			out.println("location.href='loginForm.net'");
    			out.println("</script>");
    			out.close();
    		} else {
    			out.println("<script>");
    			out.println("alert('가입 실패입니다.');");
    			out.println("history.go(-1)");
    			out.println("</script>");
    			out.close();
    		}
    	} else {
    		out.println("<script>");
			out.println("alert('이미 아이디가 존재합니다.');");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
    	}
    	return null;
    }
}