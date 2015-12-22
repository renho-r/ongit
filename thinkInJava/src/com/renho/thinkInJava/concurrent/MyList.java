package com.renho.thinkInJava.concurrent;

public class MyList {

	private int length = 0;
	
	public synchronized int size() {
		return this.length;
	}
	
	public synchronized void add() {
		this.length++;
	}
	
}
