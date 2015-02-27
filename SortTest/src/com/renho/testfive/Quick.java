/**   
* @Title: Quick.java 
* @Package com.renho.testfive 
* @Description: TODO
* @author renho   
* @date 2013年9月4日 上午11:14:55 
* @version V1.0   
*/
package com.renho.testfive;

public class Quick {

	public int[] sort(int[] array) {
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	public void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int i = low;
			int j = high;
			int value = array[low];
			while(i < j) {
				while(i<j && array[j] >= value) {
					j--;
				}
				array[i] = array[j];
				while(i<j && array[i] <= value) {
					i++;
				}
				array[j] = array[i];				
			}
			array[i] = value;
			quickSort(array, low, i);
			quickSort(array, i+1, high);
		}
	}
}

