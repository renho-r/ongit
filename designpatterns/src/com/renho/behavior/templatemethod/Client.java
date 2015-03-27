package com.renho.behavior.templatemethod;

public class Client {

	public static void main(String[] args) {
		AbstractClass abstractClass = new ConcreteClassA();
		abstractClass.templateMethod();
		abstractClass = new ConcreteClassB();
		abstractClass.templateMethod();
	}

}
