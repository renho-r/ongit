package com.renho.create.factory.abfactory;

public class NFactory implements Factory {

	@Override
	public Fruit createApple() {
		// TODO Auto-generated method stub
		return new NApple();
	}

	@Override
	public Fruit createBanana() {
		// TODO Auto-generated method stub
		return new NBanana();
	}
}
