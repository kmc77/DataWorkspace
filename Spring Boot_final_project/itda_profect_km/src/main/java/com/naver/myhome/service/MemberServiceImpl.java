package com.naver.myhome.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naver.myhome.domain.Member;
import com.naver.myhome.mybatis.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberMapper dao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImpl(MemberMapper dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }


	@Override
	public int isId(String userId) {
		Member rmember=dao.isId(userId);
		return (rmember == null) ? -1 : 1;
	}

	@Override
	public int insert(Member mem) {
		return dao.insert(mem);
	}

	@Override
	public int isId(String userId, String userPw) {
		Member rmember = dao.isId(userId);
		int result = -1;
		
		if (rmember != null) {		//아이디가 존재
			if (passwordEncoder.matches(userPw, rmember.getUserPw())) {//인코딩된 비밀번호가 DB와 일치하는지 확인
				result = 1;			//아이디 비밀번호 불일치
			}else {
				result = 0;			//아이디는 DB에 있지만 비밀번호 불일치
			}
		}
		return result;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
	

}
