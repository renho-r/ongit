package com.renho.behavior.mediator

/**
  * Created by renho on 2016/7/11.
  */
trait Mediator {
	def send(message: String, colleague: Colleague)
}
