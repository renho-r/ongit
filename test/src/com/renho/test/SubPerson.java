package com.renho.test;

import com.renho.test.pack.Person;

public class SubPerson extends Person {

	public Person person = new Person();
	public SubPerson subPerson = new SubPerson();

	public void test() {
		
//		person.defaultInt = 0;
//		person.protectedInt = 0;
		person.publicInt = 0;
		
//		person.defaultMethod();
//		person.protectedMethod();
		person.publicMethod();
		
		subPerson.defaultInt = 0;
		subPerson.protectedInt = 0;
		subPerson.publicInt = 0;
		
		subPerson.defaultMethod();
		subPerson.protectedMethod();
		subPerson.publicMethod();
	}
}
