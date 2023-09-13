package com.naver.myhome4.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome4.domain.Member;

@Repository
public class MemberDAO {
	private SqlSessionTemplate sqlSession;
	

	@Autowired
	public MemberDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


	public int insert(Member m) {
		return sqlSession.insert("Members.insert", m);
	}


	public Member idCheck(String id) {
		return sqlSession.selectOne("Members.idcheck", id);
	}
	
	
}
