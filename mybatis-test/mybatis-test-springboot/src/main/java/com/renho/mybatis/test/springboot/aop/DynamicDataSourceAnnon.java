package com.renho.mybatis.test.springboot.aop;

import java.lang.annotation.*;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicDataSourceAnnon {

    String value() default "default";

}
