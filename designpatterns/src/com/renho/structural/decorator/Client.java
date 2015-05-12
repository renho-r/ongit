package com.renho.structural.decorator;

public class Client {

	public static void main(String[] args) {
//		Component concreteComponent = new ConcreteComponent();
//		Component decoratora = new ConcreteDecoratorA(concreteComponent);
//		Component decoratorb = new ConcreteDecoratorB(decoratora);
//		decoratorb.operation();
		
		Component concreteComponent = new ConcreteComponent();
		ConcreteDecoratorA decoratora = new ConcreteDecoratorA();
		ConcreteDecoratorB decoratorb = new ConcreteDecoratorB();
		
		decoratora.setComponent(concreteComponent);
		decoratorb.setComponent(decoratora);
		decoratorb.operation();
	}
}
