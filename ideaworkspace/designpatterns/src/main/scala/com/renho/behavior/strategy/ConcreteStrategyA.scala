package com.renho.behavior.strategy

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteStrategyA extends IStrategy {
	override def algorithmInterface(context: Context): Unit = {
		println("ConcreteStrategyA:" + context.param)
	}
}
