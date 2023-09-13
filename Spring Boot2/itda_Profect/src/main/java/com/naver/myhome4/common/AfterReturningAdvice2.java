package com.naver.myhome4.common;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// 공통으로 처리할 로직을 AfterAdvice 클래스에 afterLog() 메서드로 구현합니다.
// AfterReturningAdvice : 타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행합니다.

@Service
@Aspect
public class AfterReturningAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice2.class);
	public void afterReturningLog(Object obj) {
		
		logger.info("==========================================================================");
		logger.info("[AfterReturningAdvice2] obj : " + obj.toString());
		logger.info("==========================================================================");
	}

}
