package com.renho.chapter3.recipe4test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class ExeThread implements Runnable {

	private int sleepSec;
	private CyclicBarrier cb;
	
	public ExeThread(int sleepSec, CyclicBarrier cb) {
		this.sleepSec = sleepSec;
		this.cb = cb;
	}
	
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(this.sleepSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf(Thread.currentThread().getId() + "¿ªÊ¼µÈ´ý:%sÃë\n", 10 - sleepSec);
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}
