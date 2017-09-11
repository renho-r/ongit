package com.renho.aop.auto.service.impl;

import com.renho.aop.auto.service.IRealService;

public class RealService implements IRealService{

	public String getRenho(String str) {
		System.out.println("realService--->getRenho");
		return str + "renho";
	}
	
	public String getRenhoThrowException(String str) throws Exception{
		System.out.println("realService--->getRenho");
		boolean flag = true;
		if(flag) {
			throw new Exception("renho");			
		}
		return str + "renho";
	}
}
