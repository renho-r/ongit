package com.renho.sort

/**
  * Created by renho on 2016/7/12.
  */
object Quick {
	def sort(start: Int, end: Int, arr: Array[Int]): Unit ={
		if(start < end) {
			val temp = arr(start)
			var i = start
			var j = end
			while(i < j) {
				while(i<j && arr(j) >= temp) {
					j -= 1
				}
				arr(i) = arr(j)
				while(i<j && arr(i) <= temp) {
					i += 1
				}
				arr(j) = arr(i)
			}
			arr(i) = temp
			sort(start, i, arr)
			sort(i+1, end, arr)
		}
	}
}