package com.naver.myhome.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;

/*
 	ȣ��Ǵ� ����Ͻ� �޼����� ������ JoinPoint �������̽��� �� �� �ֽ��ϴ�.
 	
 	JoinPoint �������̽��� �޼��� 
 	1. Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
 	2. Object getTarget() : ȣ���� ����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü�� ���մϴ�.
 	3. getClass().getName() : Ŭ���� �̸��� ���մϴ�.
 	4. proceeding.getSignature().getName() : ȣ��Ǵ� �޼��� �̸��� ���մϴ�.
 	
 	
 	�������� ó���� ������ BeforeAdvice Ŭ������ beforeLog() �޼���� �����մϴ�.
 	Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 	Advice Ŭ������ ������ ���� ���Ͽ��� <bean>���� ����ϰų� @Service annotation�� ����մϴ�.
 */
public class AfterAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterAdvice.class);

	public void afterLog(JoinPoint proceeding) {
		/*
		 * ��³��� [BeforeAdvice] : ����Ͻ� ���� ���� �� �����Դϴ�. [BeforeAdvice] :
		 * com.naver.myhome4.service.BoardServiceImp]�� getBoardLost() ȣ���մϴ�.
		 */
		logger.info("=======================================================================");
		logger.info("[AfterAdvice] : ����Ͻ� ���� ���� �� �����Դϴ�.");
		logger.info("[AfterAdvice] : "
					+ proceeding.getTarget().getClass().getName()
					+ "�� " + proceeding.getSignature().getName() + "() ȣ�� �� �Դϴ�.");
		logger.info("=======================================================================");
		
	}

}