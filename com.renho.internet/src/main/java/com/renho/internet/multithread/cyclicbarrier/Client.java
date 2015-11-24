package com.renho.internet.multithread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Client {

	public static void main(String[] args) {
		CallBack callBack = new CallBack();
		CyclicBarrier cb = new CyclicBarrier(10, callBack);
		callBack.setCb(cb);
		
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new MyThread(cb));
			t.start();
		}
	}

}
