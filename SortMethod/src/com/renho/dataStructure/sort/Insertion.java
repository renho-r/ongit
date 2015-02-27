package com.renho.dataStructure.sort;
/**
 * ²åÈëÅÅĞò
 * @author renho
 *
 */
public class Insertion implements Sort {

	public int[] sort(int[] array) {
		
		for(int i=0; i<array.length; i++) {
			int j = i;
			int temp = array[i];
			while(j > 0 && array[j-1] > temp) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = temp;
		}
		return array;
	}
}
