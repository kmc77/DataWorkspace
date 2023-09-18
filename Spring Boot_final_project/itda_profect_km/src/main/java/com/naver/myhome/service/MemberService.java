package com.naver.myhome.service;

import java.util.List;

import com.naver.myhome.domain.Member;


public interface MemberService {

	int isId(String userId);

	int insert(Member mem);

	int isId(String userId, String userPw);
	
	
	
}
