package com.renho.structural.facade;

public class Client {

	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.methodA();
		facade.methodB();
	}

}
