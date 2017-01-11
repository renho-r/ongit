package com.renho.structural.decorator

/**
  * Created by renho on 2016/7/11.
  */
trait Component {
	def operation()
}

class ConcreteComponent extends Component {
	override def operation(): Unit = {
		println("ConcreteComponent operation")
	}
}
