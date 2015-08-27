package com.renho.test.oneObjTwoThread;

public class Common {
	public synchronized void synchronizedMethod1() {
		System.out.println("synchronizedMethod1 called");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod1 done");
	}

	public synchronized void synchronizedMethod2() {
		System.out.println("synchronizedMethod2 called");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod2 done");
	}
}
