package com.renho.behavior.memento

/**
  * Created by renho on 2016/7/11.
  */
class Originator {
	var state: String = _
	def createMemento(): Memento = {
		new Memento(state)
	}
	def setMemento(memento: Memento): Unit = {
		this.state = memento.state
	}
	def show() {
		System.out.println("Originator:" + state);
	}
}
