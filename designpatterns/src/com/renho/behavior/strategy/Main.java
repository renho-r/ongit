package com.renho.behavior.strategy;

public class Main {

	public static void main(String[] args) {
		Context context = new Context(new StrategyImpl1());
		context.behavior();
		context = new Context(new StrategyImpl2(), "renho");
		context.behavior();
	}

}
