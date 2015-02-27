package com.renho.test;

import java.io.BufferedReader;
import java.io.FileReader;
public class DataUtil {

	public static int[] getData() throws Exception {
		FileReader fr = new FileReader("E:/galileo_workspace/Sort/src/com/renho/sort/data.txt");
		int[] aList = null;
		BufferedReader br = new BufferedReader(fr);
		String temp = br.readLine();
		int i = 0;
		while(!"".equals(temp) && null != temp) {
			System.out.println(temp);
			aList[i] = Integer.valueOf(temp);
			temp = br.readLine();
		}
		br.close();
		fr.close();
		System.out.println(aList.length);
		return aList;
	}
	
}
