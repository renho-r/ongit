package com.renho.behavior.observer.java;

import java.util.Observer;

public class Client {

	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		Observer observer = new ConcreteObserver();
		subject.addObserver(observer);
		
		subject.setName("renho");
//		subject.notifyObservers();
	}

}
