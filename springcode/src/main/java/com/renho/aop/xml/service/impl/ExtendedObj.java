package com.renho.aop.xml.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.renho.aop.xml.service.ExtendedInterface;

public class ExtendedObj implements ExtendedInterface{
	private static final Logger logger = LoggerFactory.getLogger(ExtendedObj.class);
	
	public void extendedExecute(){
		logger.info("------------->logger<------------>ExtendedObj extendedExecute().<-------------");
	}
}
