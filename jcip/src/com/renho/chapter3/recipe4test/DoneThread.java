package com.renho.chapter3.recipe4test;

public class DoneThread implements Runnable {

	@Override
	public void run() {
		System.out.println("全部到达开始DoneThread!");
	}

}
