package com.renho.chapter2.recipe1test;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Bean b = new Bean();
		
		Thread ta = new Thread(new MyThreadAdd(b));
		Thread tm = new Thread(new MyThreadMin(b));
		
		ta.start();
		tm.start();
		
		ta.join();
		tm.join();
		
		System.out.println(b.num);
	}

}
