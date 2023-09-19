package com.naver.myhome4.common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice2 {
	private static final Logger logger = LoggerFactory.getLogger(AroundAdvice2.class);
	// 1.PreceedingJoinPoing 인터페이스는 JoinPoint를 상속했기 때문에 JoinPoint가 가진 모든 메서드를 지원합니다.
	@Around("execution(* com.naver.myhome4..*Impl.get*(..))")
	public Object aroundLog(ProceedingJoinPoint proceeding) throws Throwable {
		logger.info("===============================================");
		logger.info("[Around Advice2의 before] : 비즈니스 메서드 수행 전 입니다.");
		logger.info("===============================================");
	    StopWatch sw = new StopWatch();
	    sw.start();
      
	    //이 코드의 이전과 이후에 공통 기능을 위한 코드를 위치 시키면 됩니다.
	    // 대상 객체의 메서드 (예:BoardServiceImpl.getListCount())를 호출합니다.
	    Object result = proceeding.proceed();
	    sw.stop();
	    
	    logger.info("===============================================");
	    logger.info("[Around Advice의 after]: 비즈니스 메서드 수행 후 입니다.");
      
	    //호출되는 메서드에 대한 정보를 구합니다.
	    Signature sig = proceeding.getSignature();
      
	    /*
	        * org.aspectj.lang.Signature 인터페이스는 호출되는 메서드와 관련된 정보를 제공합니다.
	        * 1. String toLongString() : 메서드를 완전하게 표현한 문장을 구합니다.
	        *    (메서드의 리턴 타입, 파라미터 타입이 모두 표시됩니다.)
	        * 2. String toShortString() : 메서드를 간략하게 표현한 문장을 구합니다.
	        */
	    
	    //BoardServiceImpl.getBoardList([1,10])
	    logger.info("[Artound Advice의 after]: "+proceeding.getTarget().getClass().getSimpleName()+"."
	    		+sig.getName()+"("+Arrays.toString(proceeding.getArgs())+")");
	    
	    //getBoardList() 메소드 수행 시간 :16(ms)초
	    logger.info("[Around Advice의 after]: "
	            + proceeding.getSignature().getName() + "() 메소드 수행 시간 :"
	            + sw.getTotalTimeMillis()+"(ms)초");
	    
	    //com.naver.myhome4.service.BoardServiceImpl
	    logger.info("[Around Advice의 after]: "
	            + proceeding.getTarget().getClass().getName()); 
	    
	    logger.info("proceeding.proceed() 실행 후 반환값 :" + result);
	    logger.info("===============================================");
	    return result;
	}
}
