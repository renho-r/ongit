package com.demo;

import javax.jws.WebService;

/** */
/**
 * implementation
 * 
 * @author
 * 
 */
@WebService
public class HelloWordImpl implements HelloWord {

	public String sayHi(String text) {
		System.out.println("开始调用接口");
		System.out.println(text);
		return "Hi" + text;
	}
}
