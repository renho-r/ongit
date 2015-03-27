package com.renho.structural.decorator;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB() {}
	
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		addBehavior();
		super.operation();
	}

	public void addBehavior() {
		System.out.println("ConcreteDecoratorB addBehavior");
	}
	
}
