package com.renho.chapter2.pc.synch;

public class Producter implements Runnable {
	
	private Products products;
	private int start;
	
	public Producter(Products products, int start) {
		this.products = products;
		this.start = start;
	}
	
	public void product() {
		for(int i=start; i<start+10; i++) {
			Product p = new Product(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.products.put(Thread.currentThread().getId(), p);
		}
	}

	@Override
	public void run() {
		product();
	}
	
}
