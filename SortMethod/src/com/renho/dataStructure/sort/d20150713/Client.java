package com.renho.dataStructure.sort.d20150713;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
//		int[] data = new int[] { 9, 12, 17, 30, 50, 20, 60, 65, 4, 49 };
		int[] data = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
//		int[] data = new int[] {10, 1, 8, 2, 9, 5, 4, 3, 7, 6};
//		createMindHeap(data, data.length/2 - 1, data.length);
		System.out.println(Arrays.toString(data));
//		for (int i = data.length - 1; i >= 1; i--) {  
//	        swap(data, i, 0);  
//	        createMindHeap(data, 0, i);  
//	    }
		
		createMaxdHeap(data, data.length/2 - 1, data.length);
		System.out.println(Arrays.toString(data));
		for (int i = data.length - 1; i >= 1; i--) {  
	        swap(data, i, 0);  
	        createMaxdHeap(data, 0, i);  
	    }
		System.out.println(Arrays.toString(data));
	}

	public static void createMaxdHeap(int[] data, int start, int length) {
		for(; start>=0; start--) {
			int leftIndex = 2 * start + 1;
			int temp = data[start];
			while(leftIndex < length) {
				int rightIndex = leftIndex + 1;
				int maxLeftOrRight = leftIndex;
				if(rightIndex < length && data[rightIndex] > data[leftIndex]) {
					maxLeftOrRight = rightIndex;
				}
				if(data[maxLeftOrRight] <= temp) {
					break;
				}
				data[start] = data[maxLeftOrRight];
				
				start = maxLeftOrRight;
				leftIndex = 2 * start + 1;
			}
			data[start] = temp;
		}
	}
	
	public static void createMindHeap(int[] data, int start, int length) {
		
		int temp, leftIndex = 2 * start + 1;
		for(; start>=0; start--) {
			// 可直接认为叶子节点是个合法的堆
			// 最后一个元素的父节点之后的所有元素都是叶子节点
			// n/2 - 1以后的都是叶子节点，合法的堆
			// 从n/2 - 1开始调整
			temp = data[start];
			leftIndex = 2 * start + 1;
			while (leftIndex < length) {// 存在左子树
				int rightIndex = leftIndex + 1;
				int minLeftOrRight = leftIndex;
				if (rightIndex < length && data[rightIndex] < data[leftIndex]) { // 在左右孩子中找最小的
					minLeftOrRight = rightIndex;
				}
				if (data[minLeftOrRight] >= temp) {//最小的大于父节点,什么也不做
					break;
				}
				data[start] = data[minLeftOrRight];     //把较小的子结点往上移动,替换它的父结点  
				//准备
				start = minLeftOrRight;  
				leftIndex = 2 * start + 1;
				System.out.println(Arrays.toString(data));
			}
			data[start] = temp;
			System.out.println(Arrays.toString(data));
		}
	}
	
	private static void swap(int[] data, int i, int z) {
		int temp = data[i];
		data[i] = data[z];
		data[z] = temp;
	}
}
