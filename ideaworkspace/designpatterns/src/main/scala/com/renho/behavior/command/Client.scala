package com.renho.behavior.command

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var receiver = new Receiver
		var invoker = new Invoker
		var ca = new ConcreteCommandA(receiver)
		invoker.addCommand(ca)
		var cb = new ConcreteCommandB(receiver)
		invoker.addCommand(cb)

		var ca0 = new ConcreteCommandA(receiver)
		invoker.addCommand(ca0)
		var ca1 = new ConcreteCommandA(receiver)
		invoker.addCommand(ca1)

		invoker.removeCommand(cb)
		invoker.exeNotify()
	}
}
