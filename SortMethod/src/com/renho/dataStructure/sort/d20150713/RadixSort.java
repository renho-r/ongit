package com.renho.dataStructure.sort.d20150713;

import java.util.Arrays;

/**
 * 基数
 * @author renho
 *
 */
public class RadixSort {

	public static void main(String[] args) {
		int[] data = new int[] { 9, 12, 117, 330, 50, 20, 60, 65, 4, 49 };
		sort(data, 3);
		System.out.println("排序后的数组：");
		System.out.println(Arrays.toString(data));
	}
	
	public static void sort(int[] data, int max) {
		int[][] t = new int[10][data.length];
		int start = 1;
		int n = 1;
		int[] count = new int[10];
		while(start<=max) {
			t = new int[10][data.length];
			count = new int[10];
			for(int i=0; i<data.length; i++) {
				int y = (data[i]/n)%10;
				t[y][count[y]] = data[i];
				count[y]++;
			}
			for(int i=0, k=0; i<10; i++) {
				for(int j=0; j<count[i]; j++) {
					data[k++] = t[i][j];
				}
			}
			start++;
			n *= 10;
		}
	}
	
}
