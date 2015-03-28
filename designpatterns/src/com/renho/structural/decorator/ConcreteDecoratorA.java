package com.renho.structural.decorator;

public class ConcreteDecoratorA extends Decorator {

	public ConcreteDecoratorA() {}
	
	public ConcreteDecoratorA(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		addBehavior();
		super.operation();
	}

	public void addBehavior() {
		System.out.println("ConcreteDecoratorA addBehavior");
	}
	
}
