package com.renho.create.factory.factorymethod;

public class Factory {

	public static Sample create(int key) {
		Sample sample = null;
		switch (key) {
		case 1:
			sample = new SampleA();
			break;
		case 2:
			sample = new SampleB();
		default:
			break;
		}
		return sample;
	}
	
}
