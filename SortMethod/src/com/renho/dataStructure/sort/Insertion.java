package com.renho.dataStructure.sort;

import java.util.Arrays;

/**
 * ≤Â»Î≈≈–Ú
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
				for(int x = 0; x<array.length; x++) {
					System.out.print(array[x] + ",");
				}
				System.out.println();
			}
			array[j] = temp;
			for(int x = 0; x<array.length; x++) {
				System.out.print(array[x] + ",");
			}
			System.out.println();
		}
		return array;
	}
}
