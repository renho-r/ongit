package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
trait State {
	def handle(context: Context)
}
