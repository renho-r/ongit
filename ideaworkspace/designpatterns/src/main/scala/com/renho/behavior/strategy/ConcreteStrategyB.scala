package com.renho.behavior.strategy

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteStrategyB extends IStrategy {
	override def algorithmInterface(context: Context): Unit = {
		println("ConcreteStrategyB:" + context.param)
	}
}
