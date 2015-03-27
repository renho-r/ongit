package com.renho.test.pack;

public class Other {

	public Person person = new Person();
	
	public void test() {
		person.defaultInt = 0;
		person.protectedInt = 0;
		person.publicInt = 0;
		
		person.defaultMethod();
		person.protectedMethod();
		person.publicMethod();
	}
}
