package com.renho.e25;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {
	public static void main(String[] args) {
		//存款
		BigDecimal d = new BigDecimal(888888);
		//月利率，乘3计算季利率
		BigDecimal r = new BigDecimal(0.001875*3);
		//计算利息
		BigDecimal i = d.multiply(r).setScale(2,RoundingMode.HALF_EVEN);		
		System.out.println("季利息是："+i);
		
		BigDecimal b = new BigDecimal(2.51);
		System.out.println(b.setScale(1,RoundingMode.UP));
	}
}
