package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
class Context(var state: State) {
	def request(): Unit ={
		state.handle(this)
	}
}
