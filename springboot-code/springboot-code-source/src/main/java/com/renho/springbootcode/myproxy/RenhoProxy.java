package com.renho.springbootcode.myproxy;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author renho
 * @date 2020/11/25
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(RenhoRegistrar.class)
public @interface RenhoProxy {

    String[] value() default {};

    String[] basePackages() default {};

}
