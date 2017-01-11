package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteStateA(var status: Int) extends State {
	override def handle(context: Context): Unit = {
		println("上午:" + status)
		context.state = new ConcreteStateB(status + 6)
	}
}
