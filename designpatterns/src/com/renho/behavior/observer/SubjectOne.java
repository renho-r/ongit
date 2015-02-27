package com.renho.behavior.observer;

public class SubjectOne implements ISubject {

	public String sta;
	
	@Override
	public void add(IObserver observer) {
		list.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		list.remove(observer);
	}

	@Override
	public void notifyOb() {
		for(IObserver o:list) {
			o.update();
		}
	}
	
}
