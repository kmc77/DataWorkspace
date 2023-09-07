package com.naver.myhome3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.myhome3.model.BbsBean;

@Controller
public class LoginController3 {
	/*
	 command ��ü�� ������ �� ����� �Ӽ� ���� �����ϰ� �ʹٸ� @ModelAttibute�� ����մϴ�.
	 ��) @ModelAttribute("hoho") BbsBean bbs
	 view ���������� "hoho"��� �̸����� ����ϸ� �˴ϴ�.
	 
	 <th>ID</th><td>${hoho.id}</td>
	 */
	@RequestMapping(value = "/login_ok3.do", method = RequestMethod.POST)
	public String login_ok3(@ModelAttribute("hoho") BbsBean bbs) {
		return "login/list3";

	}
	
	@RequestMapping(value = "/login3", method = RequestMethod.GET)
	public String login3() {
		return "login/loginForm3";
	}
}