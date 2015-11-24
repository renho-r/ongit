package com.renho.internet.multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main implements Runnable{

	private CountDownLatch cdl = new CountDownLatch(10);
	
	public static void main(String[] args) {
		Main main = new Main();
		Thread mt = new Thread(main);
		mt.start();
		for(int i=0; i<10; i++) {
			Thread t = new Thread(new MyThread(main));
			t.start();
		}
		System.out.println("main�߳��˳�!");
	}

	public void arrive() {
		cdl.countDown();
	}

	@Override
	public void run() {
		try {
			System.out.println("��ʼ�ȴ�...");
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("�ȴ����!");
	}

}
