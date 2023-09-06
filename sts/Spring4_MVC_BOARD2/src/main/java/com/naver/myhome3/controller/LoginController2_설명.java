package com.naver.myhome3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.naver.myhome3.model.BbsBean;

@Controller
public class LoginController2_���� {
	//@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login2() {
		return "login/loginForm2";//WEB-INF/views/login/loginForm.jsp �̰����� �̵��ض�
	}
	
	
	//@RequestMapping(value = "/login_ok2.do", method = RequestMethod.POST)
	public String board_write (BbsBean bbs) {

		/*
		 commend ��ü��?
		 �������� ��û �Ķ������ ���� command ��ü�� ����ִ� ����� �����մϴ�.
		 command ��ü���� �Ķ���ͷ� �Ѿ�� ������ ������ setter �޼��尡 �����ϸ� �˴ϴ�.
		 ��, �Ķ������ �̸��� property �� �̸��� ������ �˴ϴ�.
		 ���� loginForm2.jsp ���� <input type=text name=id>���� �Է��� ���� �����ϱ�����
		 setId()�޼��尡 �����ϸ� �˴ϴ�.
		 
		 String id = request.getParameter("id");
		 String pass = request.getParameter("pass");
		 
		 BbsBean bbs = new BbsBean();
		 bbs.setId(id):
		 bbs.setPass(pass);
		 
		 command ��ü�� ����ϸ� ������ ���Ǿ��� ���� �ڵ�� ����� �ϰ� �Ǿ� �ʿ� ���� �˴ϴ�.
		 command ��ü�� ����� ���� JSP���� ����ϱ� ���ؼ��� 
		 ${bbsBean.id} �Ǵ� ${bbsBean.pass}�� ����մϴ�.
		 ��, list2.jsp���� 
		 commnad ��ü�� Ŭ���� �̸�(ù ���ڸ� �ҹ��ڷ� �ٲߴϴ�.)�� ������ �Ӽ� �̸��� ����ؼ� 
		 command ��ü�� �信 �����մϴ�.
		 ���� command ��ü�� Ŭ���� �̸��� BbsBean�� ��� JSP �ڵ忡���� bbsBean�̶�� ����ؼ� 
		 command ��ü�� ������ �� �ְ� �˴ϴ�.
		 
		 
		 ��ȯ���� String���� ��� View�̸��� �����մϴ�.
		 */
		return "login/list2"; //webapp/WEB-INF/views/login/list2.jsp�� �ǹ�

	}
}
