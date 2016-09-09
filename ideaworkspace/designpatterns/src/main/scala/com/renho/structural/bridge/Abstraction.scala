package com.renho.structural.bridge

/**
  * Created by renho on 2016/7/11.
  */
class Abstraction {

	var implementor: Implementor = _

	def operation(): Unit = {
		implementor.operation()
	}
}

class RefinedAbstraction extends Abstraction {
	override def operation(): Unit = {
		implementor.operation()
	}
}