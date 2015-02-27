package com.renho.dataStructure.sort.demo;

public class Insertion implements Sort {

	public int[] sort(int[] array) {
		for(int i=0; i<array.length; i++) {
			int temp = array[i];
			int j = i;
			while(j > 0 && array[j-1] > temp) {
				array[j] = array[--j];		
			}
			array[j] = temp;
		}
		return array;
	}
}
