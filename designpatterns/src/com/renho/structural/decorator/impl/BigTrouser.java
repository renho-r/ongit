package com.renho.structural.decorator.impl;

import com.renho.structural.decorator.IClothes;

public class BigTrouser extends IClothes {

	public BigTrouser() {
		super();
	}
	
	public BigTrouser(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.println("´©BigTrouser");
		person.show();
	}
}
