package com.renho.create.singleton.test;

public class ThreadOther implements Runnable {

	public Obj obj;
	
	public ThreadOther(Obj obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		obj.list.add(SingletonTestA.getInstance());
	}

}
