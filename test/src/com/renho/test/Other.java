package com.renho.test;

import com.renho.test.pack.Person;

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
