package com.naver.myhome3.ReqquestParm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckController {
	
	
	@RequestMapping(value = "check.do", method = RequestMethod.POST)
	public String check2(String[] hobby, Model mv) {
		mv.addAttribute("hobby", hobby);
		return "check/list1";
	}
	
}
