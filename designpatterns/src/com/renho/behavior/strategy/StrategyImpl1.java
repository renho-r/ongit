package com.renho.behavior.strategy;

public class StrategyImpl1 implements IStrategy {

	@Override
	public void behavior(Context context) {
		System.out.println("Strategy1");
	}

}
