package com.renho.structural.decorator.expersonclothes;

public class IClothes extends Person {

	protected Person person = null;

	public IClothes() {
		super();
	};
	
	public IClothes(String name) {
		super(name);
	}
	
	public void decorator(Person person) {
		this.person = person;
	}
}
