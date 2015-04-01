package com.renho.structural.flyweight;

public class Client {

	public static void main(String[] args) {
		int extrinsicstate = 22;
		
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		
		FlyWeight flyWeightX = flyWeightFactory.getFlyWeight("X");
		flyWeightX.operation(--extrinsicstate);
		
		FlyWeight flyWeightY = flyWeightFactory.getFlyWeight("Y");
		flyWeightY.operation(--extrinsicstate);
		
		FlyWeight flyWeightZ = flyWeightFactory.getFlyWeight("Z");
		flyWeightZ.operation(--extrinsicstate);
		
		UnsharedConcreteFlyWeight unsharedConcreteFlyWeight = new UnsharedConcreteFlyWeight();
		unsharedConcreteFlyWeight.operation(--extrinsicstate);
	}

}
