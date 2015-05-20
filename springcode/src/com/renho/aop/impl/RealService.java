package com.renho.aop.impl;

public class RealService {

	public String getRenho(String str) {
		System.out.println("realService--->getRenho");
		return str + "renho";
	}
	
}
