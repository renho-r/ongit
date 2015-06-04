package com.renho.behavior.visitor;

public class ConcreteElementA implements Element {

	@Override
	public void Accept(Visitor visitor) {
		visitor.VisitConcreteElementA(this);
	}
}
