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
		System.out.println("��ʼ���ýӿ�");
		System.out.println(text);
		return "Hi" + text;
	}
}
