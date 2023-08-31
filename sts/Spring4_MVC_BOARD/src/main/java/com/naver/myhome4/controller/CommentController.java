package com.naver.myhome4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.myhome4.service.CommentService;

@Controller // localhost/myhome4/member로 시작하는~
@RequestMapping(value = "/comment")
public class CommentController {
	
	// import org.slf4j.Logger;
	// import org.slf4j.LoggerFacntory;
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
}
