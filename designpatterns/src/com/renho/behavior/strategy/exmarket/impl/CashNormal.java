package com.renho.behavior.strategy.exmarket.impl;

import com.renho.behavior.strategy.exmarket.CashSuper;

public class CashNormal extends CashSuper {

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
