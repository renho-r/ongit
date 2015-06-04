package com.renho.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class UserServiceCallbackFilter implements CallbackFilter {

	@Override
	public int accept(Method method) {
		if("listUser".equals(method.getName())) {
			//´úÀílistUser
			return 0;
		}
		return 1;
	}

}
