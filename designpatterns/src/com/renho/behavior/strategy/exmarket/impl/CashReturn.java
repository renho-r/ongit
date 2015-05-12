package com.renho.behavior.strategy.exmarket.impl;

import com.renho.behavior.strategy.exmarket.CashSuper;

public class CashReturn extends CashSuper {

	private double condition = 0;
	private double moneyReturn = 0;
	
	public CashReturn(double condition, double moneyReturn) {
		this.condition = condition;
		this.moneyReturn = moneyReturn;
	}
	
	@Override
	public double acceptCash(double money) {
		double backMoney = money;
		if(money > condition) {
			backMoney = backMoney - moneyReturn;
		}
		return backMoney;
	}

}
