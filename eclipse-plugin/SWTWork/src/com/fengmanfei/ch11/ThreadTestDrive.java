package com.fengmanfei.ch11;

public class ThreadTestDrive {
	public static void main(String[] args) {
		System.out.println("Hello");
		//�����̶߳���
		ExtendThread extendThread = new ExtendThread ();
		//�����̺߳�ʼ�����̶߳����е�run()������
		extendThread.start();	
		//����Child����Child��ʵ����Runnable�ӿ�
		Child child = new Child();
		//�����̶߳��󣬽�child������Ϊ�������
		Thread implementThread = new Thread ( child );
		implementThread.start();
		System.out.println("World!");
	}
}
