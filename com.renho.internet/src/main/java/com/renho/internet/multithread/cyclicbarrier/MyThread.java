package com.renho.internet.multithread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {

	private CyclicBarrier cb;
	
	public MyThread(CyclicBarrier cb) {
		this.cb = cb;
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
			System.out.println("sleep ok ...");
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
