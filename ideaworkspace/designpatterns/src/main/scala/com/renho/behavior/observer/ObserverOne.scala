package com.renho.behavior.observer

/**
  * Created by renho on 2016/7/11.
  */
class ObserverOne extends IObserver{
	override def update(): Unit = {
		println("ObserverOne -> one")
	}
}
