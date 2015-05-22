package com.renho.cglib.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;

public class AopUtils implements MethodInterceptor {

	private Map<String, Class<?>> beforeMap = new HashMap<String, Class<?>>() {
		private static final long serialVersionUID = 5912985874905650182L;
		{
			put("save", AopService.class);
			put("list", AopService.class);
		}
	};
	private Map<String, Class<?>> afterMap = new HashMap<String, Class<?>>() {
		private static final long serialVersionUID = 5912985874905650182L;
		{
			put("save", AopService.class);
		}
	};
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		
		Class<?> beforeClazz = beforeMap.get(method.getName());
		if(null != beforeClazz) {
			Object objBefore = beforeClazz.newInstance();
			Method[] methodBefores = beforeClazz.getMethods();
			for(Method m:methodBefores) {
				if("before".equals(m.getName())) {
					m.invoke(objBefore, new Object[]{});				
				}
			}			
		}
		
		Object o = methodProxy.invokeSuper(obj, args);
		
		Class<?> afterClazz = afterMap.get(method.getName());
		if(null != afterClazz) {
			Object objAfter = afterClazz.newInstance();
			Method[] methodAfters = afterClazz.getMethods();
			for(Method m:methodAfters) {
				if("after".equals(m.getName())) {
					m.invoke(objAfter, new Object[]{});				
				}
			}
		}
		return o;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<?> realClazz) {
		Enhancer enhancer = new Enhancer();
		AopUtils aopUtils = new AopUtils();
		CallbackFilter filter = new AopCallbackFilter();
		
		enhancer.setSuperclass(realClazz);
		enhancer.setCallbacks(new Callback[]{aopUtils, NoOp.INSTANCE});
		enhancer.setCallbackFilter(filter);
		
		T t = ((T) enhancer.create());
		return t;
	}
	
}
