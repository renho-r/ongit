package com.renho.bean.dao;

import com.renho.bean.pojo.Person;

public class PersonDAO {

	private Person person;

	public PersonDAO() {
		System.out.println("");
		System.out.printf("PersonDAO init\n");
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		System.out.printf("set person\n");
	}
}
