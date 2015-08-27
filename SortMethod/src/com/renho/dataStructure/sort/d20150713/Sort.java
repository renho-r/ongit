package com.renho.dataStructure.sort.d20150713;

import java.util.Arrays;

public interface Sort {

	public void sort(int[] array);
	
	public static class Client {
		public static void main(String[] args) {
			//int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5 , 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
			int[] array = {49, 38, 65, 97, 26, 13, 27, 49, 55, 4};
//			Sort sort = new Insertion();
			Sort sort = new Shell();
			Context context = new Context(sort);
			context.sort(array);
			
			show(array);
		}
		
		public static void show(int[] array) {
			System.out.print(Arrays.toString(array));
		}
	}
	
	public static class Context {
		private Sort sort;
		
		public Context(Sort sort) {
			this.sort = sort;
		}
		
		public void sort(int[] array) {
			this.sort.sort(array);
		}
	}
	
	/**
	 * ≤Â»Î≈≈–Ú
	 * @author renho
	 *
	 */
	public static class Insertion implements Sort{

		@Override
		public void sort(int[] array) {
			for(int i=1; i<array.length; i++) {
				int j = i;
				int temp = array[j];
				while(j>0 && array[j-1]>temp) {
					array[j] = array[j-1];
					Client.show(array);
					System.out.println();
					j--;
				}
				array[j] = temp;
			}
		}	
	}
	/**
	 * œ£∂˚≈≈–Ú
	 */
	public class Shell implements Sort{
		
		public void sort(int[] a) {
			int n = a.length;
			int i, j, gap;
			for (gap = n / 2; gap > 0; gap /= 2) {
				for (i = 0; i < gap; i++) {
					for (j = i + gap; j < n; j += gap)
						if (a[j] < a[j - gap]) {
							int temp = a[j];
							int k = j - gap;
							while (k >= 0 && a[k] > temp) {
								a[k + gap] = a[k];
								k -= gap;
							}
							a[k + gap] = temp;
						}
				}
			}
		}
	}
}
