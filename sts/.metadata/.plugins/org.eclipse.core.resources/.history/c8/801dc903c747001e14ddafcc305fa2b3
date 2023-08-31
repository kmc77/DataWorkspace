package com.naver.myhome4.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
