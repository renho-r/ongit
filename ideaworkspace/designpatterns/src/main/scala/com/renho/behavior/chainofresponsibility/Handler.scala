package com.renho.behavior.chainofresponsibility

/**
  * Created by renho on 2016/7/11.
  */
abstract class Handler {
	var successor: Handler = _
	def handlerRequest(request: Int)
}
