package com.naver.myhome4.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
 	* 호출되는 비즈니스 메서드의 정보를 JoinPoint 인터페이스로 알 수 있습니다.
 	* 
 	* JoinPoint 인터페이스의 메서드
 		1. Signature getSignature() : 호출되는 메서드에 대한 정보를 구합니다.
 		2. Object getTarger()	: 호출한 비즈니스 메서드를 포함하는 비즈니스 객체를 구합니다.
 		3. getClass().getName() : 클래스 이름을 구합니다.
 		4. proceeding.getSignature().getName() : 호출되는 메서드 이름을 구합니다.
 */

// 공통으로 처리할 로직을 BeforeAdvice 클래스에 beforeLog() 메서드로 구현합니다.
// Advice : 횡단 관심에 해당하는 공통 기능을 의미하며 독립된 클래스의 메서드로 작성됩니다.
// Advice 클래스는 스프링 설정 파일에서 <bean>으로 등록하거나 @Service annotation을 사용합니다.

@Service
@Aspect // @Aspect가 설정된 클래스에는 Pointcut과 Advice를 결합하는 설정이 있어야합니다.
public class BeforeAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(BeforeAdvice2.class);

	@Before("execution(* com.naver.myhome4..*Impl.get*(..))")
	public void beforeLog(JoinPoint proceeding) {
		logger.info("==========================================================================");
		logger.info("[BeforeAdvice2] : 비즈니스 로직 수행 전 동작입니다.");
		logger.info("[BeforeAdvice2] : "
				+ proceeding.getTarget().getClass().getName()
				+"의 "+proceeding.getSignature().getName()+ "() 호출합니다.");
		logger.info("==========================================================================");
	}

}
