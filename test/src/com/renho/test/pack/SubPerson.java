package com.renho.test.pack;

public class SubPerson extends Person {

	public Person person = new Person();
	
	public void test() {
		super.defaultInt = 0;
		super.protectedInt = 0;
		super.publicInt = 0;
		
		super.defaultMethod();
		super.protectedMethod();
		super.publicMethod();
		
		person.defaultInt = 0;
		person.protectedInt = 0;
		person.publicInt = 0;
		
		person.defaultMethod();
		person.protectedMethod();
		person.publicMethod();
	}
}
