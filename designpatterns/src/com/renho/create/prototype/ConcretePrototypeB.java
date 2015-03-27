package com.renho.create.prototype;

public class ConcretePrototypeB extends Prototype {

	@Override
	public Prototype clone() {
		ConcretePrototypeB concretePrototypeB = new ConcretePrototypeB();
		concretePrototypeB.setType(this.getType());
		concretePrototypeB.setPerson((Person)this.getPerson().clone());//…Óclone
		return concretePrototypeB;
	}

}
