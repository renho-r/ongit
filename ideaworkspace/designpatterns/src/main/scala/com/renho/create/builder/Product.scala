package com.renho.create.builder

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/7/8.
  */
class Product {
	private val parts: ListBuffer[String] = new ListBuffer
	def add(str: String): Unit = {
		this.parts += str
	}
	def show = this.parts.foreach(println)
}
