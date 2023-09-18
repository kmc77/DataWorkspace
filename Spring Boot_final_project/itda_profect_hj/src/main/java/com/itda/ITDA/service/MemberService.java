package com.itda.ITDA.service;

import java.util.List;

import com.itda.ITDA.domain.Member;


public interface MemberService {

	int isId(String userId);

	int insert(Member mem);

	int isId(String userId, String userPw);
	
}
