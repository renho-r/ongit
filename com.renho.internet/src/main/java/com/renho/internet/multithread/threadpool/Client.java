package com.renho.internet.multithread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class Client {

	public static void main(String[] args) {
		try {
			ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("renho-%d").setDaemon(true).build();
//			ExecutorService executor = Executors.newFixedThreadPool(2, new ThreadFactoryImpl("renho", 1));
			ExecutorService executor = Executors.newFixedThreadPool(2, threadFactory);
			executor.submit(new Callable<Object>() {
	
				public Object call() throws Exception {
					System.out.println(1);
					return null;
				}
			});
			executor.submit(new Callable<Object>() {
	
				public Object call() throws Exception {
					System.out.println(1);
					return null;
				}
			});
			executor.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(123);
	}
}
