package com.renho.structural.adapter;

public class Adapter extends Target{

	Adaptee adaptee = new Adaptee();
	
	public void request() {
		adaptee.specificRequest();
	}
	
}
