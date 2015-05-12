package com.renho.behavior.strategy.exmarket;

import com.renho.behavior.strategy.exmarket.impl.CashNormal;

public class Client {

	public static void main(String[] args) {
		double money = 500;
//		CashFactory cashFactory = new CashFactory();
//		CashSuper cashSuper0 = cashFactory.getCashSuper("CashNormal");
//		CashSuper cashSuper1 = cashFactory.getCashSuper("CashRebate");
//		CashSuper cashSuper2 = cashFactory.getCashSuper("CashReturn");
//		
//		System.out.println(cashSuper0.acceptCash(money));
//		System.out.println(cashSuper1.acceptCash(money));
//		System.out.println(cashSuper2.acceptCash(money));
		
//		CashSuper cashSuper = new CashNormal();
//		CashContext cashContext = new CashContext(cashSuper);
//		System.out.println(cashContext.exe(money));
		
		CashContext cashContext = new CashContext("CashRebate");
		System.out.println(cashContext.exe(money));
	}

}
