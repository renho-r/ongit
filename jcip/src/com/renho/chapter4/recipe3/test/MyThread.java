package com.renho.chapter4.recipe3.test;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(1);
		return (int) (Math.random() * 100);
	}

}
