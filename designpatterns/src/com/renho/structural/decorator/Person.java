package com.renho.structural.decorator;

public class Person {

	private String name;
	
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.println("Person:" + name + "-->show");
	}
}
