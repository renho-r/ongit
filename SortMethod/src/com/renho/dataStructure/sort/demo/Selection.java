package com.renho.dataStructure.sort.demo;

public class Selection implements Sort {

	public int[] sort(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			int index = i;
			for(int j=i; j<array.length; j++) {
				if(array[j] < array[index]) {
					index = j;
				}
			}
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
		return array;
	}
}
