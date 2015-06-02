package com.renho.behavior.visitor;

public class ConcreteVisitor1 implements Visitor {

	@Override
	public void VisitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA + "被" + this + "访问");
	}

	@Override
	public void VisitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB + "被" + this + "访问");
	}

}
