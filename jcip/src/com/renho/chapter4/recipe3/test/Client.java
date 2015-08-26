package com.renho.chapter4.recipe3.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		List<Future<Integer>> list = new ArrayList<>();
		for(int i=0; i<100; i++) {
			MyThread myThread = new MyThread(); 
			list.add(tpe.submit(myThread));
		}
		do {
			System.out.printf("Main: Number of Completed Tasks: %d\n", tpe.getCompletedTaskCount());
			for (int i = 0; i < list.size(); i++) {
				Future<Integer> result = list.get(i);
				System.out.printf("Main: Task %d: %s\n", i, result.isDone());
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (tpe.getCompletedTaskCount() < list.size());
		for(Future<Integer> f:list) {
			System.out.println(f.get());
		}
		tpe.shutdown();
	}

}
