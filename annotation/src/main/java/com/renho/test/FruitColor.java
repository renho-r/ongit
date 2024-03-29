package com.renho.test;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * 水果颜色注解
 * 
 * @author peida
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
	/**
	 * 颜色枚举
	 * 
	 * @author peida
	 *
	 */
	public enum Color {
		BULE, RED, GREEN
	};

	/**
	 * 颜色属性
	 * 
	 * @return
	 */
	Color fruitColor() default Color.GREEN;

}
