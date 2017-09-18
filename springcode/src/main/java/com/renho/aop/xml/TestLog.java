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
	 * ����
	 * @param joinpoint
	 */
	public void around(ProceedingJoinPoint joinpoint) {
		logger.info("------------->logger<------------>aop:round:before<-------------");
		try {
			//���ñ�֪ͨ����
			joinpoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("------------->logger<------------>aop:round:after<-------------");
	}
	/**
	 * ������
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
	 * ������
	 * @param str
	 */
	public void parameterExecuteAfter(String str) {
		logger.info("------------->logger<------------>parameterExecuteAfter<-------------");
		System.out.println("parameterExecuteAfter:arg:" + str);
	}
}
