package com.renho.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	
	@Pointcut("@annotation(com.renho.aop.annotation.Renho)")
    public void dataAccessOperation() {}
	
	@Before("com.renho.aop.annotation.SystemArchitecture.dataAccessOperation()")
    public void doAccessCheck() {
        System.out.println("before");
    }
}
