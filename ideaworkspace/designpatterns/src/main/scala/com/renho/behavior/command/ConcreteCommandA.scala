package com.renho.behavior.command

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteCommandA(receiver: Receiver) extends ICommand {
	override def execute(): Unit = {
		receiver.action1()
	}
}
