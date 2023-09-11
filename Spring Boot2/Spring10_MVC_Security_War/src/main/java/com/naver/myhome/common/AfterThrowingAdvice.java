package com.naver.myhome.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 JoinPoint �������̽��� �޼���
 
 Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 AfterReturningAdvice:Ÿ�� �޼ҵ尡 ���������� ������� ��ȯ �Ŀ� �����̽� ����� �����մϴ�. 
 
 BoardServiceImpl.java���� getBoardList()�ȿ� 
 double i = 1/0;
 �߰��մϴ�.
 */

public class AfterThrowingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice.class);

	public void afterThrowingLog(Throwable exp) {
		logger.info("=======================================================================");
		logger.info("[AfterThrowing ] : ����Ͻ� ���� ���� �� ������ �߻��ϸ� �����մϴ�.");
		logger.info("ex : " + exp.toString());
		logger.info("=======================================================================");
		
	}

}