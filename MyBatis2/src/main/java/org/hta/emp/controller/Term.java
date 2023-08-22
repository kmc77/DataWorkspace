package org.hta.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hta.emp.dao.EmpDAO;
import org.hta.emp.domain.Emp;

public class Term implements Action {
    
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        EmpDAO dao = new EmpDAO();
        
        Map<String, String> m = new HashMap<>();
        m.put("start", request.getParameter("startday"));
        m.put("end", request.getParameter("endday"));
        
        List<Emp> list = dao.getTermList(m);
        
        request.setAttribute("list", list);
        request.setAttribute("start", m.get("start"));
        request.setAttribute("end", m.get("end"));
        
        ActionForward forward = new ActionForward();
        forward.setPath("_.where/list1.jsp");
        forward.setRedirect(false);
        return forward;
    }

}
