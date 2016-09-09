package com.renho.behavior.strategy

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var iStrategyA: IStrategy = new ConcreteStrategyA
		var context: Context = new Context(iStrategyA, "paramA")
		context.contexInterface()

		var iStrategyB: IStrategy = new ConcreteStrategyB
		context.iStrategy = iStrategyB

		context.contexInterface()
	}
}
