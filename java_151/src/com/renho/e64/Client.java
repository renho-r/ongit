package com.renho.e64;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
		int[] datas = new int[100];
		for(int i=0; i<datas.length; i++) {
			datas[i] = (int) (Math.random() * 100);
			System.out.println(datas[i]);
		}
		
		int max = datas[0];
		for(int i:datas) {
			max = max>i?max:i;
		}
		System.out.println("max1:" + max);
		
		int[] datasTemp = datas.clone();
		Arrays.sort(datasTemp);
		System.out.println("max2:" + datasTemp[datasTemp.length - 1]);
		
		for(int i:datasTemp) {
			System.out.println(i);
		}
	}

}
