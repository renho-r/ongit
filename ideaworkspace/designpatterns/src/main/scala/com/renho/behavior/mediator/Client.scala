package com.renho.behavior.mediator

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var cma = new ConcreteMediatorA
		var cca = ConcreteColleagueA(cma)
		var ccb = ConcreteColleagueB(cma)

		cma.cca = cca
		cma.ccb = ccb

		cca.send("?")
		ccb.send("!")
	}
}
