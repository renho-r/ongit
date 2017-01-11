package com.renho.structural.decorator

/**
  * Created by renho on 2016/7/11.
  */
class Decorator(component: Component) extends Component {
	override def operation(): Unit = {
		this.component.operation()
	}
}

class ConcreteDecoratorA(component: Component) extends Decorator(component: Component) {
	def addBehavior() {
		println("ConcreteDecoratorA addBehavior");
	}
	override def operation(): Unit = {
		addBehavior()
		this.component.operation()
	}
}

class ConcreteDecoratorB(component: Component) extends Decorator(component: Component) {
	def addBehavior() {
		println("ConcreteDecoratorB addBehavior");
	}
	override def operation(): Unit = {
		addBehavior()
		this.component.operation()
	}
}
