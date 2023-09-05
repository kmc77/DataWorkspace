package com.naver.myhome4.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 Advice : 횡단 관심에 해당하는 공통 기능을 의미하며 독립된 클래스의 메서드로 작성됩니다.
 AfterReturningAdvice:타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행합니다. 
 */

public class AfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

	public void afterReturningLog(Object obj) {
		/*
		 * 출력내용 [BeforeAdvice] : 비즈니스 로직 수행 전 동작입니다. [BeforeAdvice] :
		 * com.naver.myhome4.service.BoardServiceImp]의 getBoardLost() 호출합니다.
		 */
		logger.info("=======================================================================");
		logger.info("[AfterReturningAdvice ] obj : " + obj.toString());
		logger.info("=======================================================================");
		
	}

}