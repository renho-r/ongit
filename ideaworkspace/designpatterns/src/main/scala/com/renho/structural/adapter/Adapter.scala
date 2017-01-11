package com.renho.structural.adapter

/**
  * Created by renho on 2016/7/11.
  */
class Target {
	def request(): Unit = {
		println("普通请求!")
	}
}

class Adapter extends Target {
	private val adaptee = new Adaptee
	override def request(): Unit = {
		adaptee.specificRequest()
	}
}

class Adaptee {
	def specificRequest(): Unit = {
		println("特殊请求!")
	}
}
