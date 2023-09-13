package com.naver.myhome4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/itda")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping(value="/main")
	public String main_itda() {
		return "main/protomain";
	}
	

}
