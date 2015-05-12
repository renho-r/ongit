package com.renho.behavior.strategy.exmarket.impl;

import com.renho.behavior.strategy.exmarket.CashSuper;

public class CashRebate extends CashSuper {
	
	private double rebate = 1;
	
	public CashRebate(double rebate) {
		this.rebate = rebate;
	}
	
	@Override
	public double acceptCash(double money) {
		return money * rebate;
	}

}
