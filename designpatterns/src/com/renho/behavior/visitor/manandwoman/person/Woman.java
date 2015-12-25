package com.renho.behavior.visitor.manandwoman.person;

import com.renho.behavior.visitor.manandwoman.Person;
import com.renho.behavior.visitor.manandwoman.Visitor;

public class Woman implements Person {

	@Override
	public void accept(Visitor visitor) {
		visitor.getWomanStatus(this);
	}
}
