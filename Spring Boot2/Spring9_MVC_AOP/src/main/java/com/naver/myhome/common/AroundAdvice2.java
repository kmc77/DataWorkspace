package com.naver.myhome.common;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

//Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
//Around Advice : ����Ͻ� �޼��� ���� ���̳� ���� �Ŀ� ����Ǵ� Advice �Դϴ�.
@Service
@Aspect //@Aspect�� ������ 
public class AroundAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(AroundAdvice2.class);

	/*
	 	1. PreceedingJoinPoint �������̽��� JoinPoint�� ����߱� ������ JoinPoint�� ���� ��� �޼��带 �����մϴ�.
	 	2. Around Advice������ ProceedingJoinPoint�� �Ű������� ����ϴµ� �� ������ proceed()�޼��尡 �ʿ��ϱ� �����Դϴ�.
	 	3. Around Advice�� ��� ����Ͻ� �޼��� ���� ����  �Ŀ� ���� �Ǵ� �� ����Ͻ� �޼��带 ȣ���ϱ� ���ؼ���
	 		ProceedingJoinPoint�� proceed()�޼��尡 �ʿ��մϴ�.
	 	*  ��, Ŭ���̾�Ʈ�� ��û�� ����æ �����̽��� Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼���(ServiceImpl�� get���� �����ϴ� �޼���) ��
	 	*  ȣ���ϱ� ���� ProceedingJoinPoint ��ü�� �Ű� ������ �޾� proceed() �޼��带 ���ؼ�
	 	*  ����Ͻ� �޼��带 ȣ���� �� �ֽ��ϴ�.
	 	*  proceed()�޼��� ���� �� �޼ҵ��� ��ȯ���� �����ؾ� �մϴ�.	
	 */
	
	@Around("execution(* com.naver.myhome4..*mpl.get*(..))")
	public Object aroundLog(ProceedingJoinPoint proceeding) throws Throwable {

		logger.info("=======================================================");
		logger.info("[Around Advice2�� before]: ����Ͻ� �޼��� ���� ���Դϴ�.");
		logger.info("=======================================================");
		StopWatch sw = new StopWatch();
		sw.start();
		
		//�� �ڵ��� ������ ���Ŀ� ���� ����� ���� �ڵ带 ��ġ ��Ű�� �˴ϴ�.
		//��� ��ü�� �޼���(�� : BoardServiceImpl.getListCount())�� ȣ���մϴ�.
		Object result = proceeding.proceed();
		
		sw.stop();
		logger.info("=======================================================");
		logger.info("[Around Advice�� after]: ����Ͻ� �޼��� ���� �� �Դϴ�.");
		
		//ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
		Signature sig = proceeding.getSignature();
		
		/*
		 org.aspectj.lang.Signature �������̽��� ȣ��Ǵ� �޼���� ���õ� ������ �����մϴ�.
		 String getName() : �޼����� �̸��� ���Ѵ�.
		 
		 
		 1. proceeding.getTarget().getClass().getSimpleName() : TargetŬ������ �̸��� �����ɴϴ�.
		 2. Object[] getArgs() : Ŭ���̾�Ʈ�� �޼��带 ȣ���� �� �Ѱ��� ���� ����� Object �迭�� �����մϴ�.
		 */
		
		//BoardServiceImpl.getBoardList([1, 10])
		logger.info("[Around Advice2�� after]: " + proceeding.getTarget().getClass().getSimpleName() + "."
					+ sig.getName() + "(" + Arrays.toString(proceeding.getArgs()) + ")" );
		
		//getBoardList() �޼ҵ� ���� �ð� : 16(ms)��
		logger.info("[Around Advice2�� after]: " 
				+ proceeding.getSignature().getName() + "() �޼ҵ� ���� �ð� :"
				+ sw.getTotalTimeMillis() + "(ms)��");
		
		//com.naver.myhome4.service.BoardServiceImpl
		logger.info("[Around Advice2�� after]: "
				+ proceeding.getTarget().getClass().getName());
				
				
		logger.info("proceeding.proceed() ���� �� ��ȯ�� :" + result);
		logger.info("=======================================================");
		return result;
	}

}