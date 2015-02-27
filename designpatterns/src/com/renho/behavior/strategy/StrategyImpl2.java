package com.renho.behavior.strategy;

public class StrategyImpl2 implements IStrategy {

	@Override
	public void behavior(Context context) {
		System.out.println("Strategy2");
		System.out.println("需要参数" + ":" + context.getPara());
	}

}
