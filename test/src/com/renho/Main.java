package com.renho;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class Main {

	public static void main(String[] args) {

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MyClass.class);
		enhancer.setCallback(new MethodInterceptorImpl());
		MyClass my = (MyClass) enhancer.create();
		my.print();
	}

	private static class MethodInterceptorImpl implements MethodInterceptor {
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			// log something
			System.out.println(method + " intercepted!");

			proxy.invokeSuper(obj, args);
			return null;
		}
	}
}
