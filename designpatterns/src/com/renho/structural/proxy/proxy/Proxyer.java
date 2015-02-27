package com.renho.structural.proxy.proxy;

public class Proxyer implements IObj {

	private Person p = new Person();
	
	@Override
	public void doSomething() {
		System.out.println("dosomething֮ǰ");
		p.doSomething();
	}

}
