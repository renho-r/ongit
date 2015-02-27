package com.renho.dataStructure.sort.demo;

public class Bubbling implements Sort {

	public int[] sort(int[] array) {
		for(int i=0; i<array.length-1; i++) {
			for(int j=i; j<array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
}
