package com.renho.test.oneObjTwoThread;

public class MyThread extends Thread {
	private int id = 0;
	private Common common;

	public MyThread(String name, int no, Common object) {
		super(name);
		common = object;
		id = no;
	}

	public void run() {
		System.out.println("Running Thread" + this.getName());
		try {
			if (id == 0) {
				common.synchronizedMethod1();
			} else if(id == 1) {
				common.synchronizedMethod2();
			}else {
				common.synchronizedMethod1();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
