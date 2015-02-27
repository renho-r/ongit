package com.renho.testone;

/**
 * 快速排序
 * @author song
 *
 */
public class Quick {
	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}
	/**
	 * 递归调用实现
	 * @param array
	 * @param low
	 * @param high
	 */
	private void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int i = low;
			int j = high;
			int value = array[low];
			while(i < j) {
				while(i < j && array[j] >= value) {
					j--;
				}
				array[i] = array[j];
				while(i < j && array[i] <= value) {
					i++;
				}
				array[j] = array[i];
			}
			array[i] = value;
			quickSort(array, low, i);
			quickSort(array, i + 1, high);
		}
	}
}
