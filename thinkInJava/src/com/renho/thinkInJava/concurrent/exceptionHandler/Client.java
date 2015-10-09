package com.renho.thinkInJava.concurrent.exceptionHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool(new MyThreadFactory());
		executor.execute(new ExceptionThread());
		executor.shutdown();
	}

}
