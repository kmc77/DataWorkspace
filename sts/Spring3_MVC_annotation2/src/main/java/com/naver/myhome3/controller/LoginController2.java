package com.naver.myhome3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.naver.myhome3.model.BbsBean;

@Controller
public class LoginController2 {
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login2() {
		return "login/loginForm2";//WEB-INF/views/login/loginForm.jsp 이공으로 이동해라
	}
	
	
	@RequestMapping(value = "/login_ok2.do", method = RequestMethod.POST)
	public String login_ok2(BbsBean bbs) {

		return "login/list2";

	}
}
