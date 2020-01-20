package com.renho.mybatis.test.springboot.aop;

import com.renho.mybatis.test.springboot.util.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Order(Integer.MAX_VALUE - 1)
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("@within(com.renho.mybatis.test.springboot.aop.DynamicDataSourceAnnon) || @annotation(com.renho.mybatis.test.springboot.aop.DynamicDataSourceAnnon)")
    public void executeService() {
    }

    @Around(value = "executeService()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) {

        String dbKey = null;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        DynamicDataSourceAnnon dynamicDataSourceAnnonAnnotation = signature.getMethod().getAnnotation(DynamicDataSourceAnnon.class);

        if (null == dynamicDataSourceAnnonAnnotation) {
            dynamicDataSourceAnnonAnnotation = joinPoint.getTarget().getClass().getAnnotation(DynamicDataSourceAnnon.class);
        }

        if (null != dynamicDataSourceAnnonAnnotation) {
            dbKey = dynamicDataSourceAnnonAnnotation.value();
            DynamicDataSource.setDataSource(dbKey);
        }
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around exception: " + throwable);
        } finally {
            DynamicDataSource.clear();
        }
        return result;
    }
}
