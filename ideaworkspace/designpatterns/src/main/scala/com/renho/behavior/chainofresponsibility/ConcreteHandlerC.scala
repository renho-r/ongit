package com.renho.behavior.chainofresponsibility

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteHandlerC extends Handler {
	override def handlerRequest(request: Int): Unit = {
		if(request > 5) {
			println("不允许");
		}else {
			println("ConcreteHandlerC:结束");
		}
	}
}
