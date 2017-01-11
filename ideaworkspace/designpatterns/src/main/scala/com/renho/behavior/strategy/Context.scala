package com.renho.behavior.strategy

/**
  * Created by renho on 2016/7/11.
  */
class Context(var iStrategy: IStrategy, var param: String) {
	def contexInterface(): Unit = {
		iStrategy.algorithmInterface(this)
	}
}
