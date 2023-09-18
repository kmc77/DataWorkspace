package com.naver.myhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.mybatis.mapper.CommentsMapper;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentsMapper dao;
	
	@Autowired
	public CommentServiceImpl(CommentsMapper dao) {
		this.dao = dao;
	}

	
}
