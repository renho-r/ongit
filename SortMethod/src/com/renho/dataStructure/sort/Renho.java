package com.renho.dataStructure.sort;

public class Renho implements Sort {

	@Override
	public int[] sort(int[] array) {
		sort(array, 0, array.length - 1);
		return array;
	}

	public void sort(int[] array, int low, int hight) {
		if(low < hight) {
			int i = low;
			int j = hight;
			int value = array[i];
			while(i<j) {
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
			sort(array, low, i);
			sort(array, i + 1, hight);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143};
//		int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55};
		Sort sort = new Renho();
		int[] reArray = sort.sort(array);
		for(int i:reArray) {
			System.out.print(i + " ");
		}
	}
}
