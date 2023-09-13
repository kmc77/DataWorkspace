package com.naver.myhome4.service;

import com.naver.myhome4.domain.Member;

public interface MemberService {
	
	public int idCheck(String id);
	
	public int insert(Member m);

	public int idCheck(String id, String password);


}
