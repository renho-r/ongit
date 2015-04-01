package com.renho.structural.flyweight;

public class UnsharedConcreteFlyWeight extends FlyWeight {

	@Override
	public void operation(int extrinsicstate) {
		System.out.println("≤ªπ≤œÌUnsharedConcreteFlyWeight:" + extrinsicstate);
	}

}
