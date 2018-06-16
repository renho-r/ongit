package com.renho.internet.multithread.producterconsumer;

public class Consumer implements Runnable {

	private MyList list;
	
	public Consumer(MyList list) {
		this.list = list;
	}
	
	public void run() {
		int count = 0;
		while(count++ < 10000) {
			try {
				System.out.println("ฯ๛ทั:" + list.remove());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
