package com.renho.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeoxyInvocationHandler implements InvocationHandler {

	private Object object;
	
	public PeoxyInvocationHandler(Object object) {
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		System.out.println("begin");
		result = method.invoke(this.object, args);
		System.out.println("end");
		return result;
	}

}
