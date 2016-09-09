package com.renho.behavior.interpret

/**
  * Created by renho on 2016/7/11.
  */
trait AbstractExpression {
	def interpret(context: Context)
}
