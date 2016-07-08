package com.renho.create.builder

/**
  * Created by renho on 2016/7/8.
  */
class ConcreteBuilderB extends Builder {
	private var product: Product = new Product

	override def buildPartA(): Unit = {
		this.product.add("部件X")
	}

	override def buildPartB(): Unit = {
		this.product.add("部件Y")
	}

	override def getResult(): Product = {
		this.product
	}
}
