package com.renho.dataStructure.sort;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143};
//		Sort sort = new Quick();
		Sort sort = new Insertion();
		int[] reArray = sort.sort(array);
		for(int i:reArray) {
			System.out.print(i + " ");
		}
	}
}
