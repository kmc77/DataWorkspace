package com.naver.myhome4.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome4.domain.Comment;

@Repository
public class CommentDAO {

	private SqlSessionTemplate sqlSession;

	@Autowired
	public CommentDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getListCount(int board_num) {
		return sqlSession.selectOne("Comments.count",board_num);
	}
	
	public List<Comment> getCommentList(Map<String, Integer> map) {
		return sqlSession.selectList("Comments.list", map);
		
	}

	public int commentsInsert(Comment c) {
		return sqlSession.insert("Comments.insert", c);
	}

	public int commentsDelete(int num) {
		return sqlSession.delete("Comments.delete", num);
	}

	public int commentsUpdate(Comment co) {
		return sqlSession.update("Comments.update", co);
	}
}
