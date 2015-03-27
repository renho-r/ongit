package com.renho.structural.decorator.expersonclothes.impl;

import com.renho.structural.decorator.expersonclothes.IClothes;

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
