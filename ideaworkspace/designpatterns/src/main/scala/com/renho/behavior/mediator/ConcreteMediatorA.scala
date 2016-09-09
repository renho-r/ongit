package com.renho.behavior.mediator

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteMediatorA extends Mediator {
	var cca: ConcreteColleagueA = _
	var ccb: ConcreteColleagueB = _
	override def send(message: String, colleague: Colleague): Unit = {
		colleague match {
			case ConcreteColleagueA(mediator) => ccb.notify(message)
			case ConcreteColleagueB(mediator) => cca.notify(message)
			case _ => println("no...")
		}
	}
}
