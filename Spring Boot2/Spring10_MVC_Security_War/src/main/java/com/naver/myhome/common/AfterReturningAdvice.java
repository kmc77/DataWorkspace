package com.naver.myhome.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 AfterReturningAdvice:Ÿ�� �޼ҵ尡 ���������� ������� ��ȯ �Ŀ� �����̽� ����� �����մϴ�. 
 */

public class AfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

	public void afterReturningLog(Object obj) {
		/*
		 * ��³��� [BeforeAdvice] : ����Ͻ� ���� ���� �� �����Դϴ�. [BeforeAdvice] :
		 * com.naver.myhome4.service.BoardServiceImp]�� getBoardLost() ȣ���մϴ�.
		 */
		logger.info("=======================================================================");
		logger.info("[AfterReturningAdvice ] obj : " + obj.toString());
		logger.info("=======================================================================");
		
	}

}