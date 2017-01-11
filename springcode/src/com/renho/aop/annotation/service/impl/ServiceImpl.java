package com.renho.aop.annotation.service.impl;

import com.renho.aop.annotation.Renho;
import com.renho.aop.annotation.service.IService;

public class ServiceImpl implements IService {

	@Renho
	@Override
	public void show() {
		System.out.println("show");
	}

	@Override
	public void nonAnnotation() {
		System.out.println("nonAnnotation");
	}
}
