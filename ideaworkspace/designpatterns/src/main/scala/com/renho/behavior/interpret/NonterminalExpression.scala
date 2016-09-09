package com.renho.behavior.interpret

/**
  * Created by renho on 2016/7/11.
  */
class NonterminalExpression extends AbstractExpression {
	override def interpret(context: Context): Unit = {
		println("nonterminal expression:" + context.input)
		context.output += "-NonterminalExpression-"
	}
}
