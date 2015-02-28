package com.renho;

public class Test {

	private static int i = 100;
	
	public static void main(String[] args) {
		int[] array = {1,20,15,11,22,11,33,44,55,66,77,88,65,34,21,21};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(array, 0, array.length - 1);
		for(int i:array) {
			System.out.println(i);
		}
		
	}

}
