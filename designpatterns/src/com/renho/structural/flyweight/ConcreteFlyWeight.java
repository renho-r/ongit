package com.renho.structural.flyweight;

public class ConcreteFlyWeight extends FlyWeight {

	@Override
	public void operation(int extrinsicstate) {
		System.out.println("π≤œÌConcreteFlyWeight:" + extrinsicstate);
	}

}
