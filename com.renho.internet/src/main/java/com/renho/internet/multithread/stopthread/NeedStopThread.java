package com.renho.internet.multithread.stopthread;

import java.util.concurrent.TimeUnit;

public class NeedStopThread implements Runnable {

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("停止线程!");
				Thread.currentThread().interrupt();//重置中断标志,即Thread.currentThread().isInterrupted() = false;
			}
		}
	}
}
