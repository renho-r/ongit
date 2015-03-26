package com.renho.behavior.strategy.exmarket;

import com.renho.behavior.strategy.exmarket.impl.CashNormal;
import com.renho.behavior.strategy.exmarket.impl.CashRebate;
import com.renho.behavior.strategy.exmarket.impl.CashReturn;

public class CashFactory {

	public CashSuper getCashSuper(String type) {
		//通过反射省略switch
		CashSuper cashSuper = null;
		switch (type) {
			case "CashNormal":
				cashSuper = new CashNormal();
				break;
			case "CashRebate":
				cashSuper = new CashRebate(0.7);
				break;
			case "CashReturn":
				cashSuper = new CashReturn(300, 100);
				break;
			default:
				break;
		}
		return cashSuper;
	}
	
}
