package com.renho.create.factory.factorymethod;

public class ConcreteFactoryB extends Factory {

	@Override
	public Product getProduct() {
		return new ProductB();
	}

}
