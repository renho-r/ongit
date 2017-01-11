package com.renho.structural.decorator

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var concreteComponent = new ConcreteComponent()
		var decoratora = new ConcreteDecoratorA(concreteComponent)
		var decoratorb = new ConcreteDecoratorB(decoratora)
		decoratorb.operation()
	}
}
