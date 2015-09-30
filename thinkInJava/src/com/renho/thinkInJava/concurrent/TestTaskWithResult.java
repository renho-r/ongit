package com.renho.thinkInJava.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTaskWithResult {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		ArrayList<Future<String>> futureList = new ArrayList<Future<String>>();
		for(int i=0; i<5; i++) {
			Callable<String> task = new TaskWithResult(i);
			futureList.add(executor.submit(task));
		}
		for(Future<String> f:futureList) {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

}
