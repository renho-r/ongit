package com.renho.internet.multithread.stopthread;

import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new NeedStopThread());
		thread.start();
		TimeUnit.SECONDS.sleep(5);
		thread.interrupt();
		thread.join();
	}
}
