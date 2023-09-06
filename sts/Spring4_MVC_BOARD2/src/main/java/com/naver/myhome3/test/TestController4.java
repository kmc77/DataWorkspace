package com.naver.myhome3.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.naver.myhome3.model.Join;

@Controller
public class TestController4 {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "test/join";
	}

	//	private   String[] hobby;
	@RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
	public String joinProcess(Join join) {
		return "test/send";
	}

}
