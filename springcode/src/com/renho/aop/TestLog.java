package com.renho.aop;

import org.aspectj.lang.JoinPoint;

public class TestLog {

	public void before(JoinPoint joinpoint) {
		System.out.println("before");
	}
	
}
