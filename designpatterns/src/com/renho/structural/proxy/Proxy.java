package com.renho.structural.proxy;

public class Proxy implements Subject {

	private Subject realSubject;
	
	public Proxy() {
		this.realSubject = new RealSubject();
	}
	
	public Proxy(Subject realSubject) {
		this.realSubject = realSubject;
	}
	
	@Override
	public void request() {		
		this.realSubject.request();
	}

}
