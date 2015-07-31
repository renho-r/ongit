package com.renho.test.oneObjTwoThread;

public class Client {

	public static void main(String[] args) {
		Common c = new Common();
		MyThread t1 = new MyThread("MyThread-1", 0, c);
		MyThread t2 = new MyThread("MyThread-2", 1, c);
		MyThread t3 = new MyThread("MyThread-2", 2, c);
		t1.start();
		t2.start();
		t3.start();
	}

}
