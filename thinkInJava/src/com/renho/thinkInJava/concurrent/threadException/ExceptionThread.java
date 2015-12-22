package com.renho.thinkInJava.concurrent.threadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		try {
			executor.execute(new ExceptionThread());
			executor.shutdown();
		}catch(Exception e) {
			System.out.println("catch the exception!!");
		}
	}

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
