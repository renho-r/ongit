package com.renho.internet.multithread.producterconsumer;

public class Producter implements Runnable {

	private MyList list;
	private String threadName;
	
	public Producter(MyList list, String threadName) {
		this.list = list;
		this.threadName = threadName;
	}
	
	public void run() {
		int count = 0;
		while(count++ < 10000) {
			try {
				list.add(this.threadName + ":" + count);
				System.out.println("Éú²ú:" + this.threadName + ":" + count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
