package com.renho.chapter2.pc.lock;

public class Client {

	public static void main(String[] args) {
		Products products = new Products();
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new Producer(products, i*10));
			t.start();
		}
		for(int i=1; i<11; i++) {
			Thread t = new Thread(new Consumer(products));
			t.start();
		}
	}

}
