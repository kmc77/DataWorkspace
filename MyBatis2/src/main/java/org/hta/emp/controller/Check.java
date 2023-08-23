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

public class Check implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
		//선택없이 보내면 deptnos는 null입니다.
		String deptnos[] = request.getParameterValues("deptno");
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Emp> list = dao.getCheck(map);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("list", list);
		request.setAttribute("deptnos", map.get("deptnos"));
		forward.setPath("_2.foreach/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
