package com.renho.test;

import com.renho.Bubbling;
import com.renho.DataUtil;

public class BubblingMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143};
//		int[] array = {88, 44, 66, 22, 11, 33, 77, 99};
		int[] array = DataUtil.getData();
		for(int o:array) {
			System.out.print(o + " - ");
		}
		Thread.sleep(1000);
		System.out.println();
		long start = System.currentTimeMillis();
		System.out.println("开始排序......");
		array = Bubbling.sort(array);
		System.out.println("排序完成......");
		long end = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("冒泡法排序时间:" + (end - start));
		for(int o:array) {
			System.out.print(o + " - ");
		}
	}

}
