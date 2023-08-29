package com.naver.myhome4.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.myhome4.service.BoardService;
import com.naver.myhome4.service.CommentService;

import org.slf4j.Logger;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	private CommentService commentService;
	
	@Autowired 
	public BoardController(BoardService boardService, CommentService commentservice) {
		this.boardService=boardService;
		this.commentService=commentService;
	}

}
