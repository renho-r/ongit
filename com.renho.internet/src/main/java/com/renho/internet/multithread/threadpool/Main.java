package com.renho.internet.multithread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
		ExecutorService executorService = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, queue);
		Future<Object> division = executorService.submit(() -> 100/0);
		try {
			division.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		
		queue = new SynchronousQueue<>();
		ExecutorService executorService0 = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, queue);
		executorService0.submit(new Task());
		executorService0.submit(new Task());
//		executorService0.submit(new Task());
		executorService0.shutdown();
		try {
			final boolean done = executorService0.awaitTermination(1, TimeUnit.SECONDS);
			System.out.println(done);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static class Task implements Callable<Object> {
		@Override
		public Object call() throws Exception {
			System.out.println("in");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("out");
			return null;
		}
	}
	
}
