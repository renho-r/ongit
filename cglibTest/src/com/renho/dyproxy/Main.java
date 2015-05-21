package com.renho.dyproxy;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		SuperImpl superImpl = new SuperImpl();
		PeoxyInvocationHandler peoxyInvocationHandler = new PeoxyInvocationHandler(superImpl);
		Super super1 = (Super) Proxy.newProxyInstance(superImpl.getClass()
				.getClassLoader(), superImpl.getClass().getInterfaces(),
				peoxyInvocationHandler);
		super1.print();
	}

}
