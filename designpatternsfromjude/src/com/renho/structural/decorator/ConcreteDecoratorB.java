package com.renho.structural.decorator;

public class ConcreteDecoratorB extends Decorator {

	public ConcreteDecoratorB() {}
	
	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	
	public void operation() {
		addedBehavior();
		super.operation();
	}

	public void addedBehavior() {
		System.out.println("addedBehavior");
	}

}
