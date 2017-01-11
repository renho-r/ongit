package com.renho.structural.adapter

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var target = new Target
		target.request()

		target = new Adapter
		target.request()
	}
}
