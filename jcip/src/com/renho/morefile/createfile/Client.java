package com.renho.morefile.createfile;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Client {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(30);
		
		for(int i=1; i<31; i++) {
			Callable<String> c = new CreateFile(i);
			executor.submit(c);
		}
		executor.shutdown();
	}

}
