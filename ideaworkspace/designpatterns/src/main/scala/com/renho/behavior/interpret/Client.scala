package com.renho.behavior.interpret

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		val context = new Context("in-renho", "out-renho")
		var list = new ListBuffer[AbstractExpression]
		list += new TerminalExpression
		list += new TerminalExpression
		list += new TerminalExpression
		list += new NonterminalExpression
		list += new NonterminalExpression
		list += new NonterminalExpression

		list.foreach(ae => ae.interpret(context))
		println(context.output)
	}
}
