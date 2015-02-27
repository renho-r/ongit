package com.renho.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public interface ISubject {

	public List<IObserver> list = new ArrayList<IObserver>();
	public void add(IObserver observer);
	public void remove(IObserver observer);
	public void notifyOb();
	
}
