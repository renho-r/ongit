package com.renho.behavior.strategy.exmarket;

import com.renho.behavior.strategy.exmarket.impl.CashNormal;
import com.renho.behavior.strategy.exmarket.impl.CashRebate;
import com.renho.behavior.strategy.exmarket.impl.CashReturn;

public class CashContext {

	private CashSuper cashSuper = null;
	
	public CashContext(String type) {
		//通过反射省略switch
		switch (type) {
			case "CashNormal":
				this.cashSuper = new CashNormal();
				break;
			case "CashRebate":
				this.cashSuper = new CashRebate(0.7);
				break;
			case "CashReturn":
				this.cashSuper = new CashReturn(300, 100);
				break;
			default:
				this.cashSuper = new CashNormal();
				break;
		}
	}
	
	public double exe(double money) {
		return this.cashSuper.acceptCash(money);
	}
}
