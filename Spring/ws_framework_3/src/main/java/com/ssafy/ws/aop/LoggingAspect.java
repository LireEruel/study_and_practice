package com.ssafy.ws.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

	@Around("execution(* com.ssafy.ws.model..*.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("메서드 선언부:" + pjp.getStaticPart().toString().replace("excution(", "").replace("))", ")"));
		System.out.println("전달 파라미터:" + Arrays.deepToString(pjp.getArgs()));
		return pjp.proceed();
	}
	
	
}
