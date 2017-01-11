package com.renho.behavior.chainofresponsibility

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var ha = new ConcreteHandlerA
		var hb = new ConcreteHandlerB
		var hc = new ConcreteHandlerC

		ha.successor = hb
		hb.successor = hc

		for(i <- 1 to 9) {
			ha.handlerRequest(i)
		}
	}
}
