package org.volhvporechja.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class SomeAspect {
	private static Logger logger = LoggerFactory.getLogger(SomeAspect.class);

	@Pointcut("execution(@org.volhvporechja.demo.aspects.Nuance * *.*())")
	public void serviceMethod() {

	}

	@Pointcut("execution(@org.volhvporechja.demo.aspects.Nuance * *.*(String)) && args(str)")
	public void serviceMethodWithParam(String str) {

	}

	@Before("serviceMethod()")
	public void Before() {
		logger.info("OH FUCK YEAR!!!");
	}

	@After("serviceMethod()")
	public void After() {
		logger.info("OH SHIT SHIT SHIT!!");
	}

	@Around("serviceMethodWithParam(str)")
	public Object Around(ProceedingJoinPoint joinpoint, String str) throws Throwable {
		long start = System.nanoTime();
		Object result = joinpoint.proceed(new Object[]{str});
		long end = System.nanoTime();
		logger.info(String.format("%s took %d ns", joinpoint.getSignature(),
				(end - start)));
		return result;
	}
}
//public aspect SomeAspect {
//	private static Logger logger = LoggerFactory.getLogger(SomeAspect.class);
//
//	pointcut serviceMethods(): execution(@org.volhvporechja.demo.aspects.Nuance * *.*(..));
//
//	pointcut serviceMethodsWithParams(String str): execution(@org.volhvporechja.demo.aspects.Nuance * *.*(String)) && args(str);
//
//	before(): serviceMethods() {
//		logger.info("OH FUCK YEAR!!!");
//	}
//
//	Object around(): serviceMethods() {
//		long start = System.nanoTime();
//		Object result = proceed();
//		long end = System.nanoTime();
//		logger.info(String.format("%s took %d ns", thisJoinPointStaticPart.getSignature(),
//				(end - start)));
//		return result;
//	}
//
//	Object around(String str): serviceMethodsWithParams(str) {
//		Object result = proceed(str);
//		logger.info(String.format("WITH PARAM: %s", str));
//		return result;
//	}
//
//	after() : serviceMethods() {
//		logger.info("OH SHIT SHIT SHIT!!");
//	}
//}
