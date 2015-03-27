package com.renho.test.pack;

public class Person {

	private int privateInt = 1;
	int defaultInt = 2;
	protected int protectedInt = 3;
	public int publicInt = 4;
	
	private void privateMethod() {
		System.out.println("privateMethod");
	}
	void defaultMethod() {
		System.out.println("defaultMethod");
	}
	protected void protectedMethod() {
		System.out.println("protectedMethod");
	}
	public void publicMethod() {
		System.out.println("publicMethod");
	}
}
