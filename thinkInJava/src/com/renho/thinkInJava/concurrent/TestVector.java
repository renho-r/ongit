package com.renho.thinkInJava.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestVector {

	public static void main(String[] args) {
	
		MyList myList = new MyList();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i=0; i<10; i++) {
			executor.execute(new MyListRunnable(myList));
		}
		executor.shutdown();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(myList.size());
	}
}
