package com.renho.aop.ch3.e3p1p2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class CountingBeforeAdvice extends MethodCounter implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		count(method);
	}
}
