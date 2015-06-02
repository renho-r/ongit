package com.renho.behavior.visitor;

public class ConcreteVisitor2 implements Visitor {

	@Override
	public void VisitConcreteElementA(ConcreteElementA concreteElementA) {
		System.out.println(concreteElementA + "��" + this + "����");
	}

	@Override
	public void VisitConcreteElementB(ConcreteElementB concreteElementB) {
		System.out.println(concreteElementB + "��" + this + "����");
	}

}
