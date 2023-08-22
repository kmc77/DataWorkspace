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

public class Term2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		Map<String, String> m = new HashMap<>();
		//startday, endday를 선택하지 않은 경우
		//request.getParameter("startday")는 "" 입니다.
		//request.getParameter("endday")는 "" 입니다.
		m.put("start", request.getParameter("startday"));
		m.put("end", request.getParameter("endday"));
		List<Emp> list = dao.getTermList2(m);
		request.setAttribute("list", list);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/where/list2.jsp");
		return forward;
	}
}
