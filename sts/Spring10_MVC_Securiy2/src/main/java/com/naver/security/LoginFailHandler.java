package com.naver.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import com.naver.myhome4.domain.Member;

//AuthenticationFailureHandler : �α��� ���� �� ó���� �۾��� �ؾ��� �� ����ϴ� �������̽��Դϴ�.
public class LoginFailHandler implements AuthenticationFailureHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginFailHandler.class);
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		logger.info(exception.getMessage());
		logger.info("�α��� ����");
		session.setAttribute("loginfail", "loginFailMsg");
		String url = request.getContextPath() + "/member/login";
		response.sendRedirect(url);
	}
	
	
}

	