package com.renho.e118.section1;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		// ���̶߳���
		MultiThread multiThread = new MultiThread();
		// �������߳�
		multiThread.start();

	}
}

class MultiThread extends Thread {
	// @Override
	// public void start(){
	// //�����߳���
	// run();
	// }

	@Override
	public void run() {
		// MultiThread do something.
		for (int i = 0; i < 1000000; i++) {
			System.out.println(Thread.currentThread().getId() + "---��ִ����");
		}
	}
}