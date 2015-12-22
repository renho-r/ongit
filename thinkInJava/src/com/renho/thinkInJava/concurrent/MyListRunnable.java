package com.renho.thinkInJava.concurrent;

import java.util.concurrent.TimeUnit;

public class MyListRunnable implements Runnable {

	private MyList myList;
	
	public MyListRunnable(MyList myList) {
		this.myList = myList;
	}
	
	@Override
	public void run() {
		synchronized(myList) {
			if(myList.size() == 0) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				myList.add();
			}
		}
	}

}
