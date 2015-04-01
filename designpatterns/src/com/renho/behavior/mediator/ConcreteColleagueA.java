package com.renho.behavior.mediator;

public class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message) {
		super.getMediator().send(message, this);
	}
	
	public void notify(String message) {
		System.out.println("ConcreteColleagueA get message:" + message);
	}
}
