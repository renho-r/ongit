package com.renho.behavior.chainofresponsibility

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteHandlerA extends Handler {
	override def handlerRequest(request: Int): Unit = {
		if(request > 1) {
			println("无法处理, 向上请求!")
			successor.handlerRequest(request)
		} else {
			println("ConcreteHandlerA结束!")
		}
	}
}
