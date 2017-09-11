package com.renho.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

	private static final Logger logger = LoggerFactory.getLogger(TestLog.class);
	
	/**
	 * before
	 * @param joinpoint
	 */
	public void before(JoinPoint joinpoint) {
		logger.info("------------->logger<------------>aop:before<-------------");
	}
	/**
	 * after
	 * @param joinpoint
	 */
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
	/**
	 * 环形
	 * @param joinpoint
	 */
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
	/**
	 * 带参数
	 * @param joinpoint
	 */
	public void parameterExecute(JoinPoint joinpoint) {
		logger.info("------------->logger<------------>parameterExecute<-------------");
		Object[] args = joinpoint.getArgs();
		for(Object arg:args) {
			System.out.println("parameterExecute:arg:" + arg);
		}
	}
	/**
	 * 带参数
	 * @param str
	 */
	public void parameterExecuteAfter(String str) {
		logger.info("------------->logger<------------>parameterExecuteAfter<-------------");
		System.out.println("parameterExecuteAfter:arg:" + str);
	}
}
