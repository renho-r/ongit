package com.renho.behavior.state

/**
  * Created by renho on 2016/7/11.
  */
class ConcreteStateC(var status: Int) extends State {
	override def handle(context: Context): Unit = {
		if(this.status >= 24) {
			println("已经休息:" + status);
		}else {
			println("晚上:" + status);
			status = status + 6;
		}
	}
}
