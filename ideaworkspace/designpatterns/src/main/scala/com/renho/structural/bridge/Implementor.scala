package com.renho.structural.bridge

/**
  * Created by renho on 2016/7/11.
  */
trait Implementor {
	def operation()
}

class ConcreteImplementorA extends Implementor {
	override def operation(): Unit = {
		println("ConcreteImplementorA -> operation")
	}
}

class ConcreteImplementorB extends Implementor {
	override def operation(): Unit = {
		println("ConcreteImplementorB -> operation")
	}
}