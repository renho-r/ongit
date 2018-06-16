package com.renho.internet.multithread.lock.fairlock;

import java.util.concurrent.TimeUnit;

public class Test implements Runnable{
	
	FairLock fl = new FairLock();
	
	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		
		t0.start();
		t1.start();
	}

	public void run() {
		try {
			fl.lock();
			TimeUnit.SECONDS.sleep(5);
			fl.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
