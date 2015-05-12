package com.renho.structural.facade;

public class Facade {

	private SubSystemOne systemOne;
	private SubSystemTwo systemTwo;
	private SubSystemThree systemThree;
	private SubSystemFour systemFour;
	
	public Facade() {
		systemOne = new SubSystemOne();
		systemTwo = new SubSystemTwo();
		systemThree = new SubSystemThree();
		systemFour = new SubSystemFour();
	}
	
	public void methodA() {
		systemOne.methodOne();
		systemTwo.methodTwo();
	}
	
	public void methodB() {
		systemThree.methodThree();
		systemFour.methodFour();
	}
}
