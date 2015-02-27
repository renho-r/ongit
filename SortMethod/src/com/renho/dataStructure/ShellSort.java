package com.renho.dataStructure;

public class ShellSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 131, 324, 543, 3451, 23, 12, 66, 43534, 3423, 654, 123, 856, 3243, 5645};
		shellsort(arr, arr.length);
		for (int i : arr) {
			System.out.print(i + "-");
		}
	}

	public static void shellsort(int[] a, int n) {
		int i, j, k, temp, gap;
		int[] gaps = { 1, 5, 13, 43, 113, 297, 815, 1989, 4711, 11969, 27901,
				84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
				58548857, 157840433, 410151271, 1131376761, 2147483647 };
		for (k = 0; gaps[k] < n; k++)
			;
		while (--k >= 0) {
			gap = gaps[k];
			for (i = gap; i < n; i++) {
				temp = a[i];
				j = i;
				while (j >= gap && a[j - gap] > temp) {
					a[j] = a[j - gap];
					j = j - gap;
				}
				a[j] = temp;
			}
		}
	}

}
