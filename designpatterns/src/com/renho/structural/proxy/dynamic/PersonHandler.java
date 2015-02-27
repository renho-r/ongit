package com.renho.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonHandler implements InvocationHandler {

	public Person p;
	
	public PersonHandler() {}
	
	public PersonHandler(Person p) {
		this.p = p;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object backObj = null;
		System.out.println("之前");
		backObj = method.invoke(this.p, args);
		System.out.println("之后");
		return backObj;
	}

}
