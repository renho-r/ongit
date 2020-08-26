package com.renho.bean.dao;

import com.renho.bean.pojo.Person;

public class PersonDAO {

	private Person person;

	public PersonDAO() {
<<<<<<< HEAD
		System.out.println("");
=======
		System.out.printf("PersonDAO init\n");
>>>>>>> 6997397a7f75bd3e5b9ef0dcf835840fff208b23
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		System.out.printf("set person\n");
	}
}
