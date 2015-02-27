/**   
* @Title: Test.java 
* @Package com.renho.inttest 
* @Description: test
* @author renho   
* @date 2013年8月29日 下午12:53:05 
* @version V1.0   
*/
package com.renho.inttest;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int[] array = new int[100];
		System.out.println(array.length);
		for(int i=0; i<array.length; i++) {
			array[i] = new Random().nextInt(999);
		}
		for(int i:array) {
			System.out.println(i);
		}
		
		System.out.println(false);
	}
}

