package com.renho.aop.auto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TestLog {

	private static final Logger logger = LoggerFactory.getLogger(TestLog.class);
	
	@Pointcut("execution(* com.renho.aop.auto.service.impl.*.*(..))")
	public void performance() {
		//定义一个切入点
	}
	
	@Before("performance()")
	public void before(JoinPoint joinpoint) {
		logger.info("------------->logger<------------>annotation:aop:before<-------------");
	}
	
	
	public void after(JoinPoint joinpoint) {
		logger.info("------------->logger<------------>aop:after<-------------");
	}
	
	public void afterReturn() {
		logger.info("------------->logger<------------>aop:afterReturn<-------------");
	}
	
	public void exception(Exception e) {
		e.printStackTrace();
		logger.info("------------->logger<------------>aop:exception<-------------");
	}
	public void around(ProceedingJoinPoint joinpoint) {
		logger.info("------------->logger<------------>aop:round:before<-------------");
		try {
			//调用被通知方法
			joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("------------->logger<------------>aop:round:after<-------------");
	}
	public void parameterExecute(JoinPoint joinpoint) {
		logger.info("------------->logger<------------>parameterExecute<-------------");
		Object[] args = joinpoint.getArgs();
		for(Object arg:args) {
			System.out.println("parameterExecute:arg:" + arg);
		}
	}
	public void parameterExecuteAfter(String str) {
		logger.info("------------->logger<------------>parameterExecuteAfter<-------------");
		System.out.println("parameterExecuteAfter:arg:" + str);
	}
}
