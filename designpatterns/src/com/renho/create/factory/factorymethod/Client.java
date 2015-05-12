package com.renho.create.factory.factorymethod;

public class Client {

	public static void main(String[] args) {
		Factory factory = new ConcreteFactoryA();
		Product product = factory.getProduct();
		System.out.println(product.getProductName());
	}

}
