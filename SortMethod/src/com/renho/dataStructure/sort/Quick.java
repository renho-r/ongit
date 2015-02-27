package com.renho.dataStructure.sort;

/**
 * ¿ìËÙÅÅĞò
 * µİ¹é
 * @author renho
 * 
 */
public class Quick implements Sort {

	private int count = 0;
	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}

	public void quickSort(int[] array, int low, int hight) {
		if (low < hight) {
			int i = low;
			int j = hight;
			int value = array[low];
			while (i < j) {
				count++;
				while (i < j && array[j] >= value) {
					j--;
				}
				array[i] = array[j];
				while (i < j && array[i] <= value) {
					i++;
				}
				array[j] = array[i];
			}
			array[i] = value;
			quickSort(array, low, i);
			quickSort(array, i + 1, hight);
		}
	}
}
