package com.renho.bean.pojo;

public class LazyinitPerson {

	public LazyinitPerson() {
		System.out.println("LazyinitPerson init");
	}
	
	private void init() {
		System.out.println("LazyinitPerson init method0");
	}
}
