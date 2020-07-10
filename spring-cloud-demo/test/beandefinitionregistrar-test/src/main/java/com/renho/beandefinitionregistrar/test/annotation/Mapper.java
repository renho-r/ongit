package com.renho.beandefinitionregistrar.test.annotation;

import java.lang.annotation.*;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Mapper {
}
