package com.renho.test.interruptedexception;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjLock {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private int count = 0;
	
	public void push(int i) {
		lock.lock();
		try {
			if(count>100) {
				count++;
				condition.signalAll();			
			}else {
				count++;
			}
			System.out.println("i= " + i + "-----><------++:" + count);		
		} catch (Exception e) {
			throw e;
		} finally {
			lock.unlock();			
		}
	}
	
	public void pop(int i) throws Exception {
		lock.lock();
		try {
			while(count <= 100) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					throw e;
				}
			}
			count--;
			System.out.println("i= " + i + "-----><--------:" + count);	
		} catch (Exception e) {
			throw e;
		}finally {
			lock.unlock();			
		}
	}
}
