package com.naver.myhome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.service.CommentService;


@RestController		//@Controller + @ResponseBody
@RequestMapping(value="/comment")
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
}
