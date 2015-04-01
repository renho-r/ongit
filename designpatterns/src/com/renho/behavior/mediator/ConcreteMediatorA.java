package com.renho.behavior.mediator;

public class ConcreteMediatorA extends Mediator {

	private ConcreteColleagueA colleagueA;
	private ConcreteColleagueB colleagueB;
	
	@Override
	public void send(String message, Colleague colleague) {
		if(colleagueA == colleague) {
			colleagueB.notify(message);
		}else {
			colleagueA.notify(message);
		}
	}

	public ConcreteColleagueA getColleagueA() {
		return colleagueA;
	}

	public void setColleagueA(ConcreteColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}

	public ConcreteColleagueB getColleagueB() {
		return colleagueB;
	}

	public void setColleagueB(ConcreteColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}
}
