package com.renho.behavior.observer

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var subject = new ConcreteSubject
		var oo = new ObserverOne
		subject.add(oo)
		var ot0 = new ObserverTwo
		subject.add(ot0)
		var ot1 = new ObserverTwo
		subject.add(ot1)
		subject.notifyObserver()
		println("------------")
		subject.remove(oo)
		subject.notifyObserver()
	}
}
