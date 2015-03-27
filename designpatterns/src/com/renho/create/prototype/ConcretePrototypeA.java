package com.renho.create.prototype;

public class ConcretePrototypeA extends Prototype {

	@Override
	public Prototype clone() {
		ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
		concretePrototypeA.setType(this.getType());
		concretePrototypeA.setPerson(this.getPerson());//ǳclone
		return concretePrototypeA;
	}
}
