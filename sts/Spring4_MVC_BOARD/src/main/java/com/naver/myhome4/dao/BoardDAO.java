package com.naver.myhome4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome4.domain.Board;

@Repository
public class BoardDAO {
	
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public BoardDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}

	public int getListCount() {
		return sqlSession.selectOne("Boards.count");
	}

	public List<Board> getBoardList(HashMap<String, Integer> map) {
		return sqlSession.selectList("Boards.list", map);
	}

}
