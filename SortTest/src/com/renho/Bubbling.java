package com.renho;

/**
 * Ã°Åİ
 * ²»Í¬ÓÚ
 * @author song
 *
 */
public class Bubbling {

	public static int[] sort(int[] array) {
		
		for(int i=0; i<array.length; i++) {
			for(int j=i; j<array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					temp = array[i];
				}
//				for(int o:array) {
//					System.out.print(o + " - ");
//				}
//				System.out.println("i = " + i + ": j = " + j);
//				System.out.println();
			}
		}
		return array;
	}
	
}
