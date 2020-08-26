package com.renho.spring.extension.aop;

import com.renho.spring.util.LogUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    public MyAspect() {
        LogUtil.logStack();
    }

    @Pointcut("execution(public * com.renho.spring.service.impl.UserServiceImpl.*(..))")
    public void dataAccessOperation() {}

    @Before("dataAccessOperation()")
    public void doAccessCheck() {
        System.out.println("before");
    }

}
