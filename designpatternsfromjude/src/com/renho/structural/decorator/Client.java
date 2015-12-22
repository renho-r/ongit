package com.renho.structural.decorator;

public class Client {

	public static void main(String[] args) {
		Component component = new ConcreteComponent();
//		Component concreteDecoratorA = new ConcreteDecoratorA(component);
		ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();
		
		concreteDecoratorB.setComponent(component);
		concreteDecoratorB.operation();
	}

}
