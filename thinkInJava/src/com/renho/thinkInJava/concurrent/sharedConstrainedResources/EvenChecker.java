package com.renho.thinkInJava.concurrent.sharedConstrainedResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private IntGenerator generator;
	private final int id;
	
	public EvenChecker(IntGenerator g, int id) {
		this.generator = g;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!generator.isCanceled()) {
			int val = generator.next();
			if(0 != val%2) {
				System.out.println(val + " not even");
				generator.canceled();
			}
		}
	}

	public static void test(IntGenerator gp, int count) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0; i<count; i++) {
			executor.execute(new EvenChecker(gp, i));
		}
		executor.shutdown();
	}
	
	public static void test(IntGenerator gp) {
		test(gp, 10);
	}
	
}
