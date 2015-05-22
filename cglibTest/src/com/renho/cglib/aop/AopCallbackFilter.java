package com.renho.cglib.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import net.sf.cglib.proxy.CallbackFilter;

public class AopCallbackFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		String[] strs = new String[]{"save", "list"};
		List<String> needList = Arrays.asList(strs);
		if(needList.contains(method.getName())) {
			return 0;
		}
		return 1;
	}

}
