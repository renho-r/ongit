package com.renho.behavior.mediator;

public class ConcreteColleagueB extends Colleague {

	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}
	
	public void send(String message) {
		super.getMediator().send(message, this);
	}
	
	public void notify(String message) {
		System.out.println("ConcreteColleagueB get message:" + message);
	}
}
