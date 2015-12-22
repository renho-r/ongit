package com.renho.internet.multithread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CallBack implements Runnable {

	private CyclicBarrier cb;
	
	@Override
	public void run() {
		System.out.println("全部到达!");
	}

	public void setCb(CyclicBarrier cb) {
		this.cb = cb;
	}

}
