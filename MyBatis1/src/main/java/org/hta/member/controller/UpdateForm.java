package org.hta.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.member.dao.MemberDao;
import org.hta.member.domain.Member;

public class UpdateForm implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActionForward forward = new ActionForward();
        String id = request.getParameter("id");
        MemberDao md = new MemberDao();
        Member mem = md.select(id);
        
        request.setAttribute("mem", mem);
        forward.setRedirect(false);
        forward.setPath("jsp/updateForm.jsp");
        return forward;
    }
}