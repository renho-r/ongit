package com.renho.create.builder

/**
  * Created by renho on 2016/7/8.
  */
class Director {
	def construct(builder: Builder): Product = {
		builder.buildPartA()
		builder.buildPartB()
		builder.getResult()
	}
}
