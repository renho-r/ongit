package com.renho.sort

/**
  * Created by renho on 2016/7/12.
  */
object Client {
	def main(args: Array[String]) {
		val arr = Array(5, 6, 9, 2, 1, 3, 8, 7, 4, 0)
		Quick.sort(0, arr.length-1, arr)
		arr.foreach(i => print(i + ", "))
	}
}
