package com.renho.dataStructure.sort.d20150713;

import java.util.Arrays;

public class Client {

	public static void main(String[] args) {
//		int[] data = new int[] { 9, 12, 17, 30, 50, 20, 60, 65, 4, 49 };
		int[] data = new int[] {6, 5, 3, 1, 8, 7, 2, 4};
//		int[] data = new int[] {10, 1, 8, 2, 9, 5, 4, 3, 7, 6};
//		createMindHeap(data, data.length/2 - 1, data.length);
		System.out.println(Arrays.toString(data));
//		for (int i = data.length - 1; i >= 1; i--) {  
//	        swap(data, i, 0);  
//	        createMindHeap(data, 0, i);  
//	    }
		
		createMaxdHeap(data, data.length/2 - 1, data.length);
		System.out.println(Arrays.toString(data));
		for (int i = data.length - 1; i >= 1; i--) {  
	        swap(data, i, 0);  
	        createMaxdHeap(data, 0, i);  
	    }
		System.out.println(Arrays.toString(data));
	}

	public static void createMaxdHeap(int[] data, int start, int length) {
		for(; start>=0; start--) {
			int leftIndex = 2 * start + 1;
			int temp = data[start];
			while(leftIndex < length) {
				int rightIndex = leftIndex + 1;
				int maxLeftOrRight = leftIndex;
				if(rightIndex < length && data[rightIndex] > data[leftIndex]) {
					maxLeftOrRight = rightIndex;
				}
				if(data[maxLeftOrRight] <= temp) {
					break;
				}
				data[start] = data[maxLeftOrRight];
				
				start = maxLeftOrRight;
				leftIndex = 2 * start + 1;
			}
			data[start] = temp;
		}
	}
	
	public static void createMindHeap(int[] data, int start, int length) {
		
		int temp, leftIndex = 2 * start + 1;
		for(; start>=0; start--) {
			// ��ֱ����ΪҶ�ӽڵ��Ǹ��Ϸ��Ķ�
			// ���һ��Ԫ�صĸ��ڵ�֮�������Ԫ�ض���Ҷ�ӽڵ�
			// n/2 - 1�Ժ�Ķ���Ҷ�ӽڵ㣬�Ϸ��Ķ�
			// ��n/2 - 1��ʼ����
			temp = data[start];
			leftIndex = 2 * start + 1;
			while (leftIndex < length) {// ����������
				int rightIndex = leftIndex + 1;
				int minLeftOrRight = leftIndex;
				if (rightIndex < length && data[rightIndex] < data[leftIndex]) { // �����Һ���������С��
					minLeftOrRight = rightIndex;
				}
				if (data[minLeftOrRight] >= temp) {//��С�Ĵ��ڸ��ڵ�,ʲôҲ����
					break;
				}
				data[start] = data[minLeftOrRight];     //�ѽ�С���ӽ�������ƶ�,�滻���ĸ����  
				//׼��
				start = minLeftOrRight;  
				leftIndex = 2 * start + 1;
				System.out.println(Arrays.toString(data));
			}
			data[start] = temp;
			System.out.println(Arrays.toString(data));
		}
	}
	
	private static void swap(int[] data, int i, int z) {
		int temp = data[i];
		data[i] = data[z];
		data[z] = temp;
	}
}
