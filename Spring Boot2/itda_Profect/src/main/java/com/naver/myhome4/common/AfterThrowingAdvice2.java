package com.naver.myhome4.common;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// 공통으로 처리할 로직을 AfterAdvice 클래스에 afterLog() 메서드로 구현합니다.
// After-throwing : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행합니다.
// BoardServiceImpl.java에서 getBoardList() 안에
// double i = 1/0; 추가합니다.

@Service
@Aspect
public class AfterThrowingAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice2.class);
	
	public void afterThrowingLog(Throwable exp) {
		logger.info("==========================================================================");
		logger.info("[AfterThrowing2] 비즈니스 로직 수행 중 오류가 발생하면 동작입니다.");
		logger.info("ex : " + exp.toString());
		if(exp instanceof Exception) {
			logger.info("예외가 발생했습니다.");
		}
		logger.info("==========================================================================");
	}

}
