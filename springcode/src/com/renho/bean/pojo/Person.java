package com.renho.bean.pojo;

public class Person {

	private String name;
	private String password;
	
	public Person() {
		System.out.println("Person init");
	}
	
	public Person(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getPersonName() {
		return "personName:renho";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
