package com.renho.structural.bridge;

public class Client {

	public static void main(String[] args) {
		Abstration abstration = new RefinedAbstration();
		abstration.setImplementor(new ConcreteImplementorA());
		abstration.operation();
		
		abstration.setImplementor(new ConcreteImplementorB());
		abstration.operation();
	}

}
