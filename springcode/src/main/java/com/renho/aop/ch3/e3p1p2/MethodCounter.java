package com.renho.aop.ch3.e3p1p2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodCounter {

	private Map<String, Integer> map = new HashMap<>();
	private int allCount;
	
	protected void count(Method m) {
		allCount++;
		System.out.println(m.getName());
	}
	
	public int getCount() {
		return this.allCount;
	}
	
}
