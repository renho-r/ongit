package com.renho.test;
import com.renho.DataUtil;
import com.renho.Quick;

public class QuickMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143};
		int[] array = DataUtil.getData();
//		array = new Quick().sort(array);
		for(int i:array) {
			System.out.print(i + " - ");
		}
		Thread.sleep(1000);
		long start = System.currentTimeMillis();
		System.out.println();
		System.out.println("��ʼ����......");
		array = new Quick().sort(array);
		System.out.println("�������......");
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("��������ʱ��:" + (end - start));
		for(int o:array) {
			System.out.print(o + " - ");
		}
	}

}
