/**   
* @Title: Quick.java 
* @Package com.renho.testfour 
* @Description: TODO
* @author renho   
* @date 2013年8月29日 上午10:17:34 
* @version V1.0   
*/
package com.renho.testfour;

public class Quick {

	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	private void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int i = low;
			int j = high;
			int value = array[i];
			while(i < j) {
				while(i < j && array[j] >= value) {
					j--;
				}
				array[i] = array[j];
				while(i < j && array[i] <= value) {
					i++;
				}
				array[j] = array[i];
			}
			array[i] = value;
			quickSort(array, low, i);
			quickSort(array, i + 1, high);
		}
	}
}

