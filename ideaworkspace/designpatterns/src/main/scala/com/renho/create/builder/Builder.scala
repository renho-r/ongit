package com.renho.create.builder

/**
  * Created by renho on 2016/7/8.
  */
abstract class Builder {
	def buildPartA()
	def buildPartB()
	def getResult(): Product
}
