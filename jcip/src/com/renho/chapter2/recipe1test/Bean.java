package com.renho.chapter2.recipe1test;

public class Bean {

	public static int num = 1000;
	
	public synchronized static void min(int anum) {
		int temp = num;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		temp -= anum;
		num = temp;
	}
	
	public synchronized void add(int anum) {
		int temp = num;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		temp += anum;
		num = temp;
	}
}
