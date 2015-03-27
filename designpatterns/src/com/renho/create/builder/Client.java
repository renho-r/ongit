package com.renho.create.builder;

public class Client {

	public static void main(String[] args) {
		Director director = new Director();
		
		Builder builder = new ConcreteBuilderA();
		director.construct(builder);
		Product product = builder.getResult();
		product.show();
		
		builder = new ConcreteBuilderB();
		director.construct(builder);
		product = builder.getResult();
		product.show();
	}

}
