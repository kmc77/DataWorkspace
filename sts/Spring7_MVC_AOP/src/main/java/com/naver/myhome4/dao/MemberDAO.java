package com.naver.myhome4.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome4.domain.Board;
import com.naver.myhome4.domain.Member;

@Repository
public class MemberDAO {
	// 생성자를 통해서 주입을 해라
	private SqlSessionTemplate sqlSession;

	@Autowired
	public MemberDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public Member isId(String id) {
		return sqlSession.selectOne("Members.idcheck", id);
	}

	public int insert(Member m) {
		return sqlSession.insert("Members.insert", m);
	}

	public Member member_info(String id) {
		return sqlSession.selectOne("Members.memberinfo", id);
	}

	public int update(Member m) {
		return sqlSession.update("Members.update", m);
	}

	public List<Member> getSearchList(Map<String, Object> map) {
		return sqlSession.selectList("Members.getSearchList", map);
	}

	public int getSearchListCount(Map<String, String> map) {
		return sqlSession.selectOne("Members.searchCount", map);
	}

	public void delete(String id) {
		  sqlSession.delete("Members.delete", id);
		}
	
}

