package com.renho.behavior.memento;

public class Originator {

	private String state;
	
	public Memento createMemento() {
		return new Memento(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void setMemento(Memento memento) {
		state = memento.getState();
	}
	
	public void show() {
		System.out.println("Originator:" + state);
	}
}
