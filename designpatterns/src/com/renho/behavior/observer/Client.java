package com.renho.behavior.observer;

public class Client {

	public static void main(String[] args) {
		
		SubjectOne iSubject = new SubjectOne();
		IObserver i1 = new ObserverOne(iSubject);
		IObserver i2 = new ObserverTwo(iSubject);
		
		iSubject.add(i1);
		iSubject.add(i2);
		
		iSubject.sta = "ready";
		
		iSubject.notifyOb();
		
	}

}
