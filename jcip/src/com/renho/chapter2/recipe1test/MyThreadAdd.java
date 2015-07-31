package com.renho.chapter2.recipe1test;

public class MyThreadAdd implements Runnable {

	private Bean b;
	
	public MyThreadAdd(Bean b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			this.b.add(100);
		}
	}

}
