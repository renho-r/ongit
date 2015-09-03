package com.renho.test.interruptedexception;

import java.util.concurrent.Callable;

public class PopCall implements Callable<String> {

	private ObjLock objLock;
	
	public PopCall(ObjLock objLock) {
		this.objLock = objLock;
	}
	
	@Override
	public String call() {
		try {
			int i = 1000;
			while((i--) > 0) {
				objLock.pop(i);			
			}			
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return null;
	}
}
