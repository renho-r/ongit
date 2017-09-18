package com.renho.aop.xml.service.impl;

import com.renho.aop.xml.service.IRealService;

public class RealService implements IRealService{

	@Override
	public String getRenho(String str) {
		System.out.println("realService--->getRenho");
		return str + "renho";
	}
	
	@Override
	public String getRenhoThrowException(String str) throws Exception{
		System.out.println("realService--->getRenho");
		boolean flag = true;
		if(flag) {
			throw new Exception("renho");			
		}
		return str + "renho";
	}
}
