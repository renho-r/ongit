package com.renho.structural.composite

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/7/11.
  */
abstract class Component(var name: String) {
	def add(component: Component)
	def remove(component: Component)
	def display(depth: Int)
}
class Composite(name: String) extends Component(name: String) {
	private val list = new ListBuffer[Component]

	override def add(component: Component): Unit = {
		list += component
	}

	override def display(depth: Int): Unit = {
		for(i <- 0 to depth) {
			print("-")
		}
		println(name)
		list.foreach(c => c.display(depth + 2))
	}

	override def remove(component: Component): Unit = {
		list -= component
	}
}
class Leaf(name: String) extends Component(name: String) {
	override def add(component: Component): Unit = {
		println("cannot add to a leaf")
	}

	override def display(depth: Int): Unit = {
		for(i <- 0 to depth) {
			print("-")
		}
		println(name)
	}

	override def remove(component: Component): Unit = {
		println("cannot remove from a leaf")
	}
}