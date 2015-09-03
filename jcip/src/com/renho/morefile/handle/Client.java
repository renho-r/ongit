package com.renho.morefile.handle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		long start = (new Date()).getTime();
		ExecutorService executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(30);
		List<Callable<Double>> list = new ArrayList<>();
		for(int i=1; i<31; i++) {
			Callable<Double> c = new HandleFile(i);
			list.add(c);
		}
		try {
			List<Future<Double>> resultList = executor.invokeAll(list);
			for(int i=0; i<resultList.size(); i++) {
				System.out.println(resultList.get(i).get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();
		long end = (new Date()).getTime();
		System.out.println(end - start);
	}

}
