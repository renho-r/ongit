package com.renho.dataStructure.sort;

import java.util.Arrays;

/**
 * Ï£¶ûÅÅÐò
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
			System.out.println(Arrays.toString(array));
			h = (h - 1)/3;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
		Sort shell = new Shell();
		shell.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
