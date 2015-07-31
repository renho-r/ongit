package com.renho.chapter3.recipe4test;

import java.util.concurrent.CyclicBarrier;

public class Client {

	public static void main(String[] args) {
		Thread dt = new Thread(new DoneThread());
		CyclicBarrier cb = new CyclicBarrier(10, dt);
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new ExeThread(i, cb));
			t.start();
		}
	}

}
