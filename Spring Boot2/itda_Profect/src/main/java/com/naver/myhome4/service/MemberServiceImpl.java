package com.naver.myhome4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome4.dao.MemberDAO;
import com.naver.myhome4.domain.Member;


@Service
public class MemberServiceImpl implements MemberService {

	private MemberDAO dao;
	
	@Autowired
	public MemberServiceImpl(MemberDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int insert(Member m) {
		return dao.insert(m);
	}

	@Override
	public int idCheck(String id) {
		Member rmember = dao.idCheck(id);
		return (rmember==null)? -1 : 1;
	}

	@Override
	public int idCheck(String id, String password) {
		Member dbmember = dao.idCheck(id);
		int result = -1;
		if(dbmember != null) {
			if(password.equals(dbmember.getUserPw())) {
				result = 1;
			}else {
				result = 0;
			}
		}
		return result;
	}

}
