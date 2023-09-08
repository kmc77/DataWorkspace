package com.naver.myhome4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController3 {
	//http://localhost:9000/myhome/index
	@GetMapping("/index2")
	public String hello() {
		return "test";
	}

}
