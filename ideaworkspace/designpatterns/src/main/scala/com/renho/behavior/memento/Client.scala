package com.renho.behavior.memento

/**
  * Created by renho on 2016/7/11.
  */
object Client {
	def main(args: Array[String]) {
		var originator = new Originator
		originator.state = "on"
		originator.show()

		var caretaker = new Caretaker(originator.createMemento())
		originator.state = "off"
		originator.show()

		originator.setMemento(caretaker.memento)
		originator.show()
	}
}
