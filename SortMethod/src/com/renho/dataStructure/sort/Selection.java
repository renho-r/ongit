package com.renho.dataStructure.sort;
/**
 * ѡ������
 * @author renho
 *
 */
public class Selection implements Sort {

	public int[] sort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int min = i;
			for(int j=i; j<array.length; j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}
}
