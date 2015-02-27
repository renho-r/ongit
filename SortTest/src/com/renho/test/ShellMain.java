package com.renho.test;

import com.renho.DataUtil;
import com.renho.Shell;

public class ShellMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] array = DataUtil.getData();
//		array = new Quick().sort(array);
		for(int i:array) {
			System.out.print(i + " - ");
		}
		Thread.sleep(1000);
		long start = System.currentTimeMillis();
		System.out.println();
		System.out.println("��ʼ����......");
		array = new Shell().sort(array);
		System.out.println("�������......");
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Shell����ʱ��:" + (end - start));
		for(int o:array) {
			System.out.print(o + " - ");
		}
	}

}
