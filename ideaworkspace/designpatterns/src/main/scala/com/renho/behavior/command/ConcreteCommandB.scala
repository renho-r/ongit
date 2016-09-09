package com.renho.behavior.command

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteCommandB(receiver: Receiver) extends ICommand {
	override def execute(): Unit = {
		receiver.action2()
	}
}
