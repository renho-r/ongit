package com.renho.thinkInJava.concurrent.exceptionHandler;

public class ExceptionThread implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
	}

}
