package com.renho;

public class QuickSort {
	
	public void sort(int[] array, int low, int hight) {
		if(low < hight) {
			int i = low;
			int j = hight;
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
			if(low < i) {
				sort(array, low, i - 1);				
			}
			if(i < hight) {
				sort(array, i + 1, hight);				
			}
		}
	}
	
}
