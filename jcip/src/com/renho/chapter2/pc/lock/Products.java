package com.renho.chapter2.pc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Products {

	private List<Product> products = new ArrayList<Product>();
	private Lock lock = new ReentrantLock();
	private Condition fullCon = lock.newCondition();
	private Condition emptyCon = lock.newCondition();
	
	public void put(long id, Product p) {
		lock.lock();
		while(products.size() >= 100) {
			try {
				fullCon.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.products.add(p);
		System.out.println(id + "生产了:" + p);
		emptyCon.signalAll();
		lock.unlock();
	}
	
	public Product get(long id) {
		lock.lock();
		while(products.size() == 0) {
			try {
				emptyCon.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Product p = products.remove(0);
		System.out.println(id + "消费了:" + p);
		fullCon.signalAll();
		lock.unlock();
		return p;
	}
	
}
