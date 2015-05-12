package com.renho.lambda;

@FunctionalInterface
public interface FunctionalDefaultMethods {
	
    void method();
    default void defaultMethod() {
    	System.out.println("defaultMethod");
    }
}
