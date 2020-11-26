package com.renho.springbootcode.aop;

import com.renho.springbootcode.util.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author renho
 * @date 2020/11/26
 */
@Aspect
@Component
public class MyAspect {
    /**
     * 切点
     * */
    @Pointcut("execution(public * com.renho.springbootcode.aop.target.*.*(..)))")
    public void AspectPointcut(){

    }

    /**
     * 前置通知
     */
    @Before("AspectPointcut()")
    public void doBefore(JoinPoint joinPoint){
        LogUtil.mark();
    }

    /**
     * 后置通知
     */
    @After("AspectPointcut()")
    public Object doAfter(JoinPoint joinPoint){
        LogUtil.mark();
        return "hello doAfter";
    }

    /**
     * 环绕通知
     */
    @Around("AspectPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        LogUtil.mark();
//        Object[] args = joinPoint.getArgs();
        Object[] args = { "haha" };
        try {
            Object result = joinPoint.proceed(args);
            System.out.println(result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "hello doAround";
    }

    /**
     * 返回通知
     */
    @AfterReturning(pointcut = "AspectPointcut()", returning = "returningValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returningValue){
        LogUtil.mark();
    }

    /**
     * 异常通知
     */
    @AfterThrowing("AspectPointcut()")
    public void doAfterThrowing(){
        LogUtil.mark();
    }
}
