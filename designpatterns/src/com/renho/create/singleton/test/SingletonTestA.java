package com.renho.create.singleton.test;

import java.io.Serializable;

public class SingletonTestA implements Serializable{

	private static final long serialVersionUID = 1L;
	private static SingletonTestA instance = null;
	
	private SingletonTestA() {}
	
	public synchronized static SingletonTestA getInstance() {
		if(null == instance) {
			instance = new SingletonTestA();
		}
		return instance;
	}
}
