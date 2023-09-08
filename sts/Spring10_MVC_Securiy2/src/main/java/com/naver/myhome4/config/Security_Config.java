package com.naver.myhome4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.RememberMeConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.naver.security.CustomAccessDeniedHandler;
import com.naver.security.CustomUserDetailsService;
import com.naver.security.LoginFailHandler;
import com.naver.security.LoginSuccessHandler;

@EnableWebSecurity //�������� ��ť��Ƽ ����
@Configuration

public class Security_Config extends WebSecurityConfigurerAdapter {
	
	// <security:http> ���� �κ�
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/resources/**/**").permitAll()
			.antMatchers("/member/login").permitAll()
			.antMatchers("/member/join").permitAll()
			.antMatchers("/member/idcheck").permitAll()
			.antMatchers("/member/joinProcess").permitAll()
			.antMatchers("/member/list").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/member/info").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')");

			
		http.formLogin().loginPage("/member/login")
						.loginProcessingUrl("/member/loginProcess")
						 .usernameParameter("id")
						 .passwordParameter("password")
						 .successHandler(loginSuccessHandler())
						 .failureHandler(loginFailHandler());
						 
						 
		/*
		 (1) logoutSuccessUrl : �α׾ƿ� �� �̵��� �ּ�
		 (2) logoutUrl (���⼭ ó���ϱ� ������ ��Ʈ�ѷ� logout ���� �մϴ�. post����� �䱸�մϴ�.)
		 (3) invalidateHttpSession : �α׾ƿ��� ���� �Ӽ��� ����
		 (4) deleteCookies : ��Ű ����				 
		 */
		
		http.logout().logoutSuccessUrl("/member/logout")
		.logoutUrl("/member/logout")
		.invalidateHttpSession(true)
		.deleteCookies("remember-me", "JSESSION_ID");
								
		 http.rememberMe() // CSRF ���� ��� ��Ȱ��ȭ				 
         .rememberMeParameter("remember-me")
         .rememberMeCookieName("remember-me")
         .tokenValiditySeconds(2419200);
		
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
		
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder());
	}
	
	//�α��� ������ ������ ��ü ����
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() { 
		return new LoginSuccessHandler(); //��Ű�� com.naver.security�� �����ϴ� ��� Ŭ���� ���Ͽ� @Service ����
	}
	
	/*
	 1. UserDetailsService �������̽��� DB���� ���� ������ �ҷ����� loadUserByUsername()�� �����մϴ�.
	 �̸� �����ϴ� Ŭ������ DB���� ������ ������ �����ͼ� UserDetails Ÿ������ ������ �ִ� �۾��� �մϴ�.
	 2. UserDetails�� �������̽��� Security���� ������� ������ ��� �������̽��Դϴ�.
	 3. UserDetails �������̽��� ������ Ŭ������ ������ ������� ������ ����ڰ� ���� ������ ������ ó���ؼ� ��ȯ�ϰ� �˴ϴ�.
	 ��) UserDetails user = new User(username, users.getPassword(), roles);
	 */
	
	@Bean
	public UserDetailsService customUserService() {
		return new CustomUserDetailsService(); //��Ű�� com.naver.security�� �����ϴ� ��� Ŭ���� ���Ͽ� 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler loginFailHandler() {
		return new LoginFailHandler();
	}

	@Bean
    public RememberMeConfigurer<HttpSecurity> rememberMeConfig() {
        return new RememberMeConfigurer<>();
    }
	

}
