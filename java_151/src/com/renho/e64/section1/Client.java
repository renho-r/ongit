package com.renho.e64.section1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Client {

	public static void main(String[] args) {
		int[] data = new int[10000];
		Random random = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = random.nextInt(1000000);
		}
		int max2 = max2(data);
		int max = max(data);
		System.out.println(max3(data));

	
	}

	// ���������㷨�����ֵ
	public static int max(int[] data) {
		int max = data[0];
		for (int i : data) {
			max = max > i ? max : i;
		}
		return max;
	}

	// ������������ȡ���ֵ
	public static int max2(int[] data) {
		// ������
		Arrays.sort(data.clone());
		// Ȼ��ȡֵ
		return data[data.length - 1];
	}
	
	//ת����List��Ȼ��ȥ���ֵ
	public static int max3(int[] data){
		List list = Arrays.asList(data);
		System.out.println(list.size());
		return 0;
		
	}

}
