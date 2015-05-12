package com.renho.behavior.mediator;

public class Client {

	public static void main(String[] args) {
		ConcreteMediatorA mediator = new ConcreteMediatorA();
		ConcreteColleagueA cnreteColleagueA = new ConcreteColleagueA(mediator);
		ConcreteColleagueB cnreteColleagueB = new ConcreteColleagueB(mediator);
		
		mediator.setColleagueA(cnreteColleagueA);
		mediator.setColleagueB(cnreteColleagueB);
		
		cnreteColleagueA.send("what?");
		cnreteColleagueB.send("»¹Ã»");
	}

}
