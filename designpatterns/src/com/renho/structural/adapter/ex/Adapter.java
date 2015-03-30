package com.renho.structural.adapter.ex;

public class Adapter extends Person implements Job {

	@Override
	public void speakFrench() {
		System.out.println("I can speak French!");
	}
}
