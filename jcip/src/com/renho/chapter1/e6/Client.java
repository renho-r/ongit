package com.renho.chapter1.e6;

import java.util.Date;

public class Client {

	public static void main(String[] args) {
		DataSourcesLoader dsl = new DataSourcesLoader();
		Thread thread1 = new Thread(dsl, "DataSourcesLoader");
		
		NetConnectionsLoader ncl = new NetConnectionsLoader();
		Thread thread2 = new Thread(ncl, "NetConnectionsLoader");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Configuration has been loaded:%s\n", new Date());
	}

}
