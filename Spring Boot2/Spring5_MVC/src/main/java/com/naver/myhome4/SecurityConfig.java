package com.naver.myhome4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //스프링과 시큐리티 결합
@Configuration
public class SecurityConfig {
   
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	  
	  http.csrf().disable(); //csrf 사용하지 않아요
	  
	  http.formLogin().loginPage("/member/login");
	  
	  return http.build();
  }
  
  @Bean
  public BCryptPasswordEncoder encodePassword() {
	  return new BCryptPasswordEncoder();
  }
   
}
