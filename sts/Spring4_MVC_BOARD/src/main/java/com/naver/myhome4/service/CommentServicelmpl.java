package com.naver.myhome4.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome4.dao.CommentDAO;
import com.naver.myhome4.domain.Comment;

@Service
public class CommentServicelmpl implements CommentService {

	private CommentDAO dao;

	@Autowired
	public CommentServicelmpl(CommentDAO dao) {
		this.dao = dao;
	}

	@Override
	public int getListCount(int board_num) {
		return dao.getListCount(board_num);
	}

	@Override
	public List<Comment> getCommentList(int board_num, int page) {
		int startrow = 1;
		int endrow = page * 3;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("board_num", board_num);
		map.put("start", startrow);
		map.put("end", endrow);
		return dao.getCommentList(map);
	}

	@Override
	public int commentsInsert(Comment c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(Comment co) {
		// TODO Auto-generated method stub
		return 0;
	}

}
