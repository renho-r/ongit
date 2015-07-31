package com.renho.chapter2.pc.synch;

public class Consumer implements Runnable {
	
	public Products products;
	public Consumer(Products products) {
		this.products = products;
	}
	public synchronized void consum() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.products.get(Thread.currentThread().getId());
	}
	@Override
	public void run() {
		while(true) {
			consum();
		}
	}
}
