package com.renho.create.factory.abfactory;

public class Test {

	@org.junit.Test
	public void test() {
		Factory factory = new NFactory();
		Fruit f = factory.createApple();
		f.print();
		f = factory.createBanana();
		f.print();
		
		NSFactory nsFactory = new AppleFactory();
		f = nsFactory.cteatNFruit();
		f.print();
		f = nsFactory.cteatSFruit();
		f.print();
	}

}
