package com.renho.create.factory.factorymethod;

public class Test {

	@org.junit.Test
	public void test() {
//		Sample sample = Factory.create(1);
		Sample sample = Factory.create(2);
		sample.say();
	}

}
