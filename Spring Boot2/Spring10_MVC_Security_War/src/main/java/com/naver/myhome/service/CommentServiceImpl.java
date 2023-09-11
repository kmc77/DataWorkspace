package com.naver.myhome.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome.domain.Comment;
import com.naver.myhome.mybatis.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentMapper dao;
	
	@Autowired
	public CommentServiceImpl(CommentMapper dao) {
		this.dao = dao;
	}

	@Override
	public int getListCount(int board_num) {
		return dao.getListCount(board_num);
	}

	@Override
	public List<Comment> getCommentList(int board_num, int page) {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int startrow = 1;
		int endrow = page*3;
		
		map.put("board_num", board_num);
		map.put("start", startrow);
		map.put("end", endrow);
	
		return dao.getCommentList(map);
	}

	@Override
	public int commentsInsert(Comment c) {
		return dao.commentsInsert(c);
	}

	@Override
	public int commentsDelete(int num) {
	      return dao.commentsDelete(num);
	}

	@Override
	public int commentsUpdate(Comment co) {
	      return dao.commentsUpdate(co);
	}
	
	

}
