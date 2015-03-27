package com.renho.create.prototype;

import com.renho.create.prototype.ex.Sample;

public abstract class Prototype {

	private String type;
	
	private Person person;
	
	public abstract Prototype clone();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Prototype) {
			if(this.type.equals(((Prototype)obj).getType())) {
				return true;
			}
		}
		return false;
	}
}
