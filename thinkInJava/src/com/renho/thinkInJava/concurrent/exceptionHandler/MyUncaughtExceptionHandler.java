package com.renho.thinkInJava.concurrent.exceptionHandler;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("catch exception:" + e);
	}

}
