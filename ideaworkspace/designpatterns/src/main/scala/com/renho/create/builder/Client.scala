package com.renho.create.builder

/**
  * Created by renho on 2016/7/8.
  */
object Client {
	def main(args: Array[String]) {
		val builderA = new ConcreteBuilderA
		val director = new Director
		val product = director.construct(builderA)
		product.show
	}
}
