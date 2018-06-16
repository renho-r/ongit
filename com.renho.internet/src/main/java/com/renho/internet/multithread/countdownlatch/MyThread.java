package com.renho.internet.multithread.countdownlatch;

import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {

	private Main main;
	
	public MyThread(Main main) {
		this.main = main;
	}
	
	@Override
	public void run() {
		try {
			long time = (long) (Math.random() * 10);
			System.out.println("sleep:" + time);
			TimeUnit.SECONDS.sleep(time);
			System.out.println("sleep ok");
			main.arrive();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
