package com.naver.myhome3.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.naver.myhome3.model.BbsBean;

/**
 	Controller ����
 	1. Controller(interface)
 	2. AbstractController
 	3. AbstractCommandController
 	4. MultiActionController
 			���� interface/class�� ����Ͽ� Controller�� �ۼ��մϴ�.
 			
 			���� �⺻�� �Ǵ� Controller �ۼ� �մϴ�.
 			AbstractController�� ��� �ް� �������̵� �ؼ� �ڵ带 �����մϴ�.
 */
@Controller
public class BbsWriteController extends AbstractController {
	
	private BbsBean b;
	public void setBbsBean(BbsBean b) {
		this.b = b;
	}
	
	//ModelAndView:Controller ó�� ��� �� ������  View�� View�� ������ ���� �����մϴ�.
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//web.xml�� ���� �������� �Ʒ� ������ ���̻� �ʿ� �����ϴ�.
		//request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id").trim();
		String pass = request.getParameter("pass").trim();
		
		b.setId(id); b.setPass(pass);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		//�� ����� ���� �ǹ� : ModelAndView mv = new ModelAndView("list");
		//ViewResolver�� ���� webapp/view/list.jsp�� ã�ư��� �˴ϴ�.
		
		mv.addObject("bkey", b);
		//addObjec�� ù ��° �Ű������� Ű(key), �� ��° �Ű������� ��(Value)�� �ǹ��մϴ�.
		//b�� id�� ��й�ȣ�� ����Ǿ� �ִ� DTO ��ü �Դϴ�.
		//ModelAndView�� ���� ������ ���� webapp/view/list.jsp���� EL�� ��Ÿ�� �� �ֽ��ϴ�.
		//ID : ${bkey.id} <br>
		//��й�ȣ : ${bkey.pass} <br>
		
		return mv;
	}
	
}
