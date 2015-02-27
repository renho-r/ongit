package com.renho.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		
		Person p = new Person();
		PersonHandler ph = new PersonHandler(p);
		IObj iobj = (IObj) Proxy.newProxyInstance(Person.class.getClassLoader(), Person.class.getInterfaces(), ph);
		iobj.doSomething();
	}

}
