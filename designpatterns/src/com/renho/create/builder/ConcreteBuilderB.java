package com.renho.create.builder;

public class ConcreteBuilderB extends Builder {

	private Product product = new Product();
	
	@Override
	public void buildPartA() {
		product.add("����X");
	}

	@Override
	public void buildPartB() {
		product.add("����Y");
	}

	@Override
	public Product getResult() {
		return product;
	}

}
