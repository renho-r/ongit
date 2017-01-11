package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteStateB(var status: Int) extends State {
	override def handle(context: Context): Unit = {
		println("中午:" + status)
		context.state = new ConcreteStateC(status + 6)
	}
}
