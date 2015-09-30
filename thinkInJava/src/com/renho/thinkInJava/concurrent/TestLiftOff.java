package com.renho.thinkInJava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLiftOff {

	public static void main(String[] args) {
//		LiftOff liftOff = new LiftOff();
//		liftOff.run();
//		Thread t0 = new Thread(new LiftOff());
//		t0.start();
//		System.out.println("wait for liftoff");
//		for(int i=0; i< 5; i++) {
//			Thread t = new Thread(new LiftOff());
//			t.start();
//		}
//		ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorService executor = Executors.newFixedThreadPool(5);
//		ExecutorService executor = Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++) {
			executor.execute(new LiftOff());
		}
		executor.shutdown();
	}

}
