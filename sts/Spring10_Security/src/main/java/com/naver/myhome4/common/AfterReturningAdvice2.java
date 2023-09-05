package com.naver.myhome4.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
 Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 AfterReturningAdvice:Ÿ�� �޼ҵ尡 ���������� ������� ��ȯ �Ŀ� �����̽� ����� �����մϴ�. 
 */
//@Service
//@Aspect //@Aspect�� ������ 
public class AfterReturningAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice2.class);

	@AfterReturning(
				pointcut="execution(* com.naver.myhome4..*Impl.get*(..))",
				returning="obj")
	public void afterReturningLog(Object obj) {
		/*
		 * ��³��� [BeforeAdvice] : ����Ͻ� ���� ���� �� �����Դϴ�. [BeforeAdvice] :
		 * com.naver.myhome4.service.BoardServiceImp]�� getBoardLost() ȣ���մϴ�.
		 */
		logger.info("=======================================================================");
		logger.info("[AfterReturningAdvice2 ] : ����Ͻ� ���� ���� �� �����Դϴ�.");
		logger.info("[AfterReturningAdvice2 ] obj : " + obj.toString());
		logger.info("=======================================================================");
		
	}

}