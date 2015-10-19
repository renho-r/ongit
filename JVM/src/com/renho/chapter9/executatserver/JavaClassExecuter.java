package com.renho.chapter9.executatserver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaClassExecuter {

	public static String execute(byte[] classByte) {
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(classByte);
		try {
			Method method = clazz.getMethod("main", new Class[] {String[].class});
			method.invoke(null, new String[] {null});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return HackSystem.getBufferString();
	}
	
}
