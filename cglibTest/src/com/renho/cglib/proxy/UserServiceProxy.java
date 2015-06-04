package com.renho.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserServiceProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
//		if("listUser".equals(method.getName())) {
			System.out.println("���÷���:" + method.getName());
			System.out.println("������:" + methodProxy.getSuperName());			
//		}
		methodProxy.invokeSuper(obj, args);
		return null;
	}

}
