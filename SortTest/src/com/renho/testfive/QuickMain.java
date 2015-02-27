package com.renho.testfive;
import java.io.File;
import java.io.FileWriter;

import com.renho.DataUtil;
import com.renho.Quick;

public class QuickMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		int[] array = {88, 44, 66, 22, 11, 33, 77, 99, 55, 45, 76, 89, 100, 143};
		int[] array = DataUtil.getData();
//		array = new Quick().sort(array);
		for(int i:array) {
			System.out.print(i + " - ");
		}
		Thread.sleep(1000);
		long start = System.currentTimeMillis();
		System.out.println();
		System.out.println("排序开始");
		array = new Quick().sort(array);
//		new QSortAlgorithm().sort(array);
		System.out.println("排序结束");
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println("排序时间:" + (end - start));
		
		FileWriter fw = new FileWriter(new File("E:/Keplerworkspace/SortTest/src/com/renho/testfive/sortOK.txt"));
		
		for(int o:array) {
			fw.write(o + "\n");
			System.out.print(o + " - ");
		}
		fw.close();
	}

}
