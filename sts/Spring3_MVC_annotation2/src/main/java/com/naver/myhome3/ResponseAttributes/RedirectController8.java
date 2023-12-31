package com.naver.myhome3.ResponseAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController8 {
	
	/*
	 http://localhost:8088/myhome3/first 실행 후
	 => http://localhost:8088/myhome3/go?attr=addAttribute
	 	addFlashAttribute로 보낸 데이터 출력하는 방법 : ${flash }=addFlashAttribute
	 	addAttribute로 보낸 데이터 출력하는 방법 : ${param.attr}=addAttribute
	 	=> 새로 고침
	 	
	 */
	
	
	@RequestMapping(value = "/first")
	public String first(RedirectAttributes rattr) {
		rattr.addFlashAttribute("flash", "addFlashAttribute");
		rattr.addAttribute("attr", "addAttribute");
		return "redirect:/go";
	}
	
	@RequestMapping(value = "/go")
	public String redirect() {
		return "redirect2/go";
	}
	
	
	@RequestMapping(value = "/redirectForm")
	public String redirectForm() {
		return "redirect2/loginForm";
	}
	
	@RequestMapping(value = "/redirect.do")
	public String redirect_idcheck(String id, String pass, RedirectAttributes rattr) {
		int result = 1;
		if(id.equals("java") && pass.equals("java")) {
			result = 2;
		} else if(id.equals("java")) {
			result = -1;
		}
		
		if (result == -1 || result == 1) {
			rattr.addFlashAttribute("result", result);
			//rattr.addAttribute("result", result);
			
			return "redirect:redirectForm";
		}
		
		return "redirect2/success";
	}
	
}
