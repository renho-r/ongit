package com.renho.behavior.command

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/7/11.
  */
class Invoker {
	private var commands = new ListBuffer[ICommand]

	def addCommand(command: ICommand): Unit = {
		commands += command
	}

	def removeCommand(command: ICommand): Unit = {
		commands -= command
	}

	def exeNotify(): Unit = {
		commands.foreach(command => command.execute())
	}
}
