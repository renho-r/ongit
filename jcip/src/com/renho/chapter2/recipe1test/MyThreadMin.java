package com.renho.chapter2.recipe1test;

public class MyThreadMin implements Runnable {

	private Bean b;
	
	public MyThreadMin(Bean b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			this.b.min(100);
		}
	}

}
