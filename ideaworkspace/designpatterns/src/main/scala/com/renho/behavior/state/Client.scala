package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var state = new ConcreteStateA(6)
		var context = new Context(state)
		context.request()
		context.request()
		context.request()
		context.request()
		context.request()
		context.request()
	}
}
