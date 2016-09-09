package com.renho.behavior.observer

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteSubject extends ISubject {
	override def add(observer: IObserver): Unit = {
		list += observer
	}

	override def notifyObserver(): Unit = {
		list.foreach(observer => observer.update())
	}

	override def remove(observer: IObserver): Unit = {
		list -= observer
	}
}
