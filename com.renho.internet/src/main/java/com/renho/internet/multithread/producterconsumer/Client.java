package com.renho.internet.multithread.producterconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		MyList list = new MyList();
		ExecutorService productExcutor = Executors.newFixedThreadPool(10);
		ExecutorService consumerExcutor = Executors.newFixedThreadPool(10);
		
		for(int i=0; i<10; i++) {
			Producter p = new Producter(list, "product" + i);
			productExcutor.submit(p);
			Consumer c = new Consumer(list);
			consumerExcutor.submit(c);
		}
		
		productExcutor.shutdown();
		consumerExcutor.shutdown();
		
		productExcutor.awaitTermination(1000, TimeUnit.SECONDS);
		consumerExcutor.awaitTermination(1000, TimeUnit.SECONDS);
		System.out.println(list.size());
	}

}
