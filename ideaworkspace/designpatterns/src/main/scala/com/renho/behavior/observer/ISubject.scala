package com.renho.behavior.observer

import scala.collection.mutable.ListBuffer

/**
  * Created by renho on 2016/7/11.
  */
trait ISubject {
	var list = new ListBuffer[IObserver]
	def add(observer: IObserver)
	def remove(observer: IObserver)
	def notifyObserver()
}
