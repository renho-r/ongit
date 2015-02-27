package com.renho.dataStructure.sort.demo;

public class Quick implements Sort {

	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}

	public int[] quickSort(int[] array, int left, int right) {
		if (left < right) {
			int low = left;
			int hig = right;
			int part = array[left];
			while (low < hig) {
				while (low < hig && array[hig] >= part) {
					hig--;
				}
				array[low] = array[hig];
				while (low < hig && array[low] <= part) {
					low++;
				}
				array[hig] = array[low];
			}
			array[low] = part;
			quickSort(array, left, low);
			quickSort(array, low + 2, right);
		}

		return array;
	}
}
