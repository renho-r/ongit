package com.renho.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestTarget {
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface TYPE_RENHO {
		public String tableName() default "";
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface FIELD_RENHO {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.CONSTRUCTOR)
	public @interface CONSTRUCTOR_RENHO {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.LOCAL_VARIABLE)
	public @interface LOCAL_VARIABLE_RENHO {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface METHOD_RENHO {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.PACKAGE)
	public @interface PACKAGE_RENHO {

	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.PARAMETER)
	public @interface PARAMETER_RENHO {
		public String value() default "";
	}
}
