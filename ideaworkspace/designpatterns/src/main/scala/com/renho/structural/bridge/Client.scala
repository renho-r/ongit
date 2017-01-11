package com.renho.structural.bridge

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var abstraction = new RefinedAbstraction
		abstraction.implementor = new ConcreteImplementorA
		abstraction.operation()
		abstraction.implementor = new ConcreteImplementorB
		abstraction.operation()
	}
}
