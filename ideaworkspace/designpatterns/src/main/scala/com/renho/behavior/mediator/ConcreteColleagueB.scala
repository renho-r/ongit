package com.renho.behavior.mediator

/**
  * Created by renho on 2016/7/11.
  */
case class ConcreteColleagueB(mediator: Mediator) extends Colleague(mediator: Mediator) {
	def send(message: String): Unit = {
		mediator.send(message, this)
	}
	def notify(message: String): Unit = {
		println("ConcreteColleagueB-notify:" + message)
	}
}
