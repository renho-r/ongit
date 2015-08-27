package com.renho.dataStructure.sort.d20150713;

import java.util.Arrays;

/**
 * 并归
 * @author renho
 *
 */
public class MergeSort {

	public static void main(String[] args) {
//		int[] data = new int[] { 9, 12, 17, 30, 50, 20, 60, 65, 4, 49 };
		int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		sort(data);
		System.out.println("排序后的数组：");
		System.out.println(Arrays.toString(data));
	}
	
	public static void sort(int[] data) {
		sort(data, 0, data.length - 1);
	}
	
	public static void sort(int[] data, int left, int right) {
		if(left < right) {
			int center = (left + right)/2;
			sort(data, left, center);
			sort(data, center+1, right);
			merge(data, left, center, right);
		}
	}
	
	public static void merge(int[] data, int left, int center, int right) {
		int mid = center + 1;
		int[] tempData = new int[data.length];
		int tempIndex = left;
		int bLeft = left;
		//left: left - center;
		//right: mid - right;
		while(left<=center && mid<=right) {
			if(data[left] <= data[mid]) {
				tempData[tempIndex++] = data[left++];
			}else {
				tempData[tempIndex++] = data[mid++];
			}
		}
		while(left<=center) {
			tempData[tempIndex++] = data[left++];
		}
		while(mid<=right) {
			tempData[tempIndex++] = data[mid++];
		}
		System.out.println(Arrays.toString(data));
		while(bLeft <= right) {
			data[bLeft] = tempData[bLeft++];
		}
	}
	
}
