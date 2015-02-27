package com.renho.create.factory.abfactory;

public class AppleFactory implements NSFactory {

	@Override
	public Fruit cteatNFruit() {
		// TODO Auto-generated method stub
		return new NApple();
	}

	@Override
	public Fruit cteatSFruit() {
		// TODO Auto-generated method stub
		return new SApple();
	}

}
