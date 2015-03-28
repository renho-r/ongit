package com.renho.create.factory.factorymethod;

public class ConcreteFactoryA extends Factory {

	@Override
	public Product getProduct() {
		return new ProductA();
	}

}
