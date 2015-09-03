package com.renho.test.interruptedexception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ObjLock ol = new ObjLock();
		Callable<String> popCall = new PopCall(ol);
		Callable<String> pushCall = new PushCall(ol);
		executor.submit(popCall);
		executor.submit(pushCall);
		executor.shutdownNow();
	}

}
