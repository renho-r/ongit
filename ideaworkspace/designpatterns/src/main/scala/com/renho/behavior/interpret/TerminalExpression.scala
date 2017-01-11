package com.renho.behavior.interpret

/**
  * Created by renho on 2016/7/11.
  */
class TerminalExpression extends AbstractExpression {
	override def interpret(context: Context): Unit = {
		println("terminal expression:" + context.input)
		context.output += "-TerminalExpression-"
	}
}
