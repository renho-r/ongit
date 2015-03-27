package com.renho.structural.decorator.expersonclothes.impl;

import com.renho.structural.decorator.expersonclothes.IClothes;

public class TShirts extends IClothes {

	public TShirts() {
		super();
	}
	
	public TShirts(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.println("´©TShirts");
		person.show();
	}
}
