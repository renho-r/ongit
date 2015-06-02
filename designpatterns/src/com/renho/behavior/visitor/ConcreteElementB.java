package com.renho.behavior.visitor;

public class ConcreteElementB implements Element {

	@Override
	public void Accept(Visitor visitor) {
		visitor.VisitConcreteElementB(this);
	}
}
