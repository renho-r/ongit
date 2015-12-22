package com.renho.internet.multithread.producterconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyList {

	private List<String> list;
	int count;
	private ReentrantLock lock;
	private Condition addCon;
	private Condition removeCon;
	
	public MyList() {
		list = new ArrayList<String>();
		count = 100;
		lock = new ReentrantLock();
		addCon = lock.newCondition();
		removeCon = lock.newCondition();
	}
	
	public void add(String product) throws InterruptedException {
		lock.lock();
		while(list.size() == count) {
			addCon.await();
		}
		list.add(product);
		removeCon.signalAll();
		lock.unlock();
	}
	
	public String remove() throws InterruptedException {
		lock.lock();
		while(list.size() == 0) {
			removeCon.await();
		}
		String back = list.remove(list.size() - 1);
		addCon.signalAll();
		lock.unlock();
		return back;
	}

	public int size() {
		return list.size();
	}
	
}
