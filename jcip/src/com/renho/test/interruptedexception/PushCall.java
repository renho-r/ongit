package com.renho.test.interruptedexception;

import java.util.concurrent.Callable;

public class PushCall implements Callable<String> {

	private ObjLock objLock;
	
	public PushCall(ObjLock objLock) {
		this.objLock = objLock;
	}
	
	@Override
	public String call() {
		try {
			int i = 1000;
			while((i--) > 0) {
				objLock.push(i);			
			}			
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return null;
	}
}
