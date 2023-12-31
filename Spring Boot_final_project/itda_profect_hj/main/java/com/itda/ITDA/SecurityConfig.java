package com.itda.ITDA;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.itda.ITDA.security.CustomAccessDeniedHandler;
//import com.itda.ITDA.security.CustomUserDetailService;
import com.itda.ITDA.security.LoginFailHandler;
import com.itda.ITDA.security.LoginSuccessHandler;

@EnableWebSecurity	//스프링과 시큐리티 결합
@Configuration
public class SecurityConfig {
	@Autowired
	private DataSource datasource;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/**").permitAll();
		
		
		//로그인 관련 설정
		http.formLogin().loginPage("/main/protomain")
						.loginProcessingUrl("/member/loginProcess")
						.usernameParameter("userId")
						.passwordParameter("userPw")
						.successHandler(loginSuccessHandler())
						.failureHandler(loginFailHandler());
		
//		//로그아웃 관련 설정
//		http.logout().logoutSuccessUrl("/member/login") // 로그아웃 후 이동할 주소 
//			.logoutUrl("/member/logout") 				// 컨트롤러의 logout을 제거하는 대신 여기서 처리(post 방식 요구)
//			.invalidateHttpSession(true)				//로그아웃 시 세션 속성들 제거
//			.deleteCookies("remember-me", "JSESSION_ID"); // 쿠키 제거 
		
		http.rememberMe()
			.rememberMeParameter("remember-me")
			//.userDetailsService(customUserService())
			.tokenValiditySeconds(2419200)
			.tokenRepository(tokenRepository());
		
		http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
		
		return http.build();
	}
	
	
	AuthenticationManager authenticationManager(
		AuthenticationConfiguration authenticationConfiguration) throws Exception {
			return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler loginFailHandler() {
		return new LoginFailHandler();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
//	@Bean
//	public UserDetailsService customUserService() {
//		return new CustomUserDetailService();
//	}
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(datasource);
		return jdbcTokenRepository;
	}

	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
}
