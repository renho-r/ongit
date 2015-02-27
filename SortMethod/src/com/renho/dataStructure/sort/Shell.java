package com.renho.dataStructure.sort;
/**
 * Ï£¶ûÅÅĞò
 * @author renho
 *
 */
public class Shell implements Sort {

	public int[] sort(int[] array) {
		int h = 1;
		while(h < array.length/3) {
			h = h * 3 + 1;
		}
		while(h > 0) {
			for(int i=h; i < array.length; i++) {
				int temp = array[i];
				int j = i;
				while(j > h - 1 && array[j - h] > temp) {
					array[j] = array[j - h];
					j = j - h;
				}
				array[j] = temp;
			}
			h = (h - 1)/3;
		}
		return array;
	}
}
