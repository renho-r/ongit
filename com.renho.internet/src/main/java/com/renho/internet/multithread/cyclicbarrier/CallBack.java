package com.renho.internet.multithread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CallBack implements Runnable {

	private CyclicBarrier cb;
	
	@Override
	public void run() {
		System.out.println("ȫ������!");
	}

	public void setCb(CyclicBarrier cb) {
		this.cb = cb;
	}

}
