package com.renho.sort
import scala.util.control.Breaks._
/**
  * Created by renho on 2016/7/12.
  */
object HeadSort {

	def main(args: Array[String]) {
		var data = Array(6, 5, 3, 1, 8, 7, 2, 4)
		sort(data, HeadSort.createMaxHeap)
		data.foreach(i => print(i + ", "))
		println
		sort(data, HeadSort.createMinHeap)
		data.foreach(i => print(i + ", "))
	}

	def sort(data: Array[Int], method: (Array[Int], Int, Int) => Unit): Unit = {
		println(method)
		method(data, data.length/2 - 1, data.length)
		for(i <- 0 until data.length) {
			swap(data, 0, data.length - 1 - i)
			method(data, 0, data.length - 1 - i)
		}
	}

	def createMaxHeap(arr: Array[Int], start: Int, length: Int): Unit = {
		for(i <- 0 to start) {
			var index = start - i
			var leftIndex = 2 * index + 1
			var temp = arr(index)
			breakable {
				while(leftIndex < length) {
					var rightIndex = leftIndex + 1
					var maxLeftOrRight = leftIndex
					if(rightIndex < length && arr(rightIndex) > arr(leftIndex)) {
						maxLeftOrRight = rightIndex
					}
					if(temp >= arr(maxLeftOrRight)) {
						break
					}
					arr(index) = arr(maxLeftOrRight)
					index = maxLeftOrRight
					leftIndex = 2 * index + 1
				}
			}
			arr(index) = temp
		}
	}

	def createMinHeap(arr: Array[Int], start: Int, length: Int): Unit = {
		for(i <- 0 to start) {
			var index = start-i
			var leftIndex = 2 * index + 1
			var temp = arr(index)
			breakable {
				while(leftIndex < length) {
					var rightIndex = leftIndex + 1
					var minLeftOrRight = leftIndex
					if (rightIndex < length && arr(rightIndex) < arr(leftIndex)) {
						minLeftOrRight = rightIndex;
					}
					if (arr(minLeftOrRight) >= temp) {
						break
					}
					arr(index) = arr(minLeftOrRight)
					index = minLeftOrRight
					leftIndex = 2 * index + 1
				}
			}
			arr(index) = temp
		}
	}

	def swap(arr: Array[Int], i: Int, j: Int): Unit = {
		var t = arr(i)
		arr(i) = arr(j)
		arr(j) = t
	}
}
