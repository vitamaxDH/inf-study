package kr.co.infStudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingAop {

	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		
		// 실행된 메소드 로그 찍기
		log.info(joinPoint.getSignature().toString());
		
		return joinPoint.proceed();
	}
}

