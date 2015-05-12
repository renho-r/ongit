package com.renho.behavior.observer.java;

import java.util.Observable;

public class ConcreteSubject extends Observable {
	
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(this.name.equals(name)) {
			
		}else {
			this.name = name;
			setChanged();
			notifyObservers();
		}
	}

}
