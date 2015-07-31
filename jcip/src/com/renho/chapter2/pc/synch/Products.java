package com.renho.chapter2.pc.synch;

import java.util.ArrayList;
import java.util.List;

public class Products {

	private List<Product> products = new ArrayList<Product>();
	
	public synchronized void put(long id, Product p) {
		while(products.size() >= 100) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.products.add(p);
		System.out.println(id + "生产了:" + p);
		notifyAll();
	}
	
	public synchronized Product get(long id) {
		while(products.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Product p = products.remove(0);
		System.out.println(id + "消费了:" + p);
		notifyAll();
		return p;
	}
	
}
