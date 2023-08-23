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

public class Term3 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		Map<String, String> m = new HashMap<>();
		m.put("start", request.getParameter("startday"));
		m.put("end", request.getParameter("endday"));
		m.put("deptno", request.getParameter("deptno"));
		
		List<Emp> list = dao.getTermList3(m);
		ActionForward forward = new ActionForward();
		request.setAttribute("list", list);
		request.setAttribute("start", m.get("start"));
		request.setAttribute("end", m.get("end") );
		request.setAttribute("deptno", m.get("deptno"));
		forward.setPath("/_1.where/list2.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
