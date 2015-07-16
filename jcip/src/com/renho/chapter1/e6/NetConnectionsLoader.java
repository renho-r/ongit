package com.renho.chapter1.e6;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetConnectionsLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning net connection loading: %s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Net connection loading has finished: %s\n", new Date());
	}

}
