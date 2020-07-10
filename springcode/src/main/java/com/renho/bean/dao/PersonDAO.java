package com.renho.bean.dao;

import com.renho.bean.pojo.Person;

public class PersonDAO {

	private Person person;

	public PersonDAO() {
		System.out.println("");
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
