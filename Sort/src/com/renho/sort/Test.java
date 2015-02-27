package com.renho.sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String fileName = System.getProperty("user.dir") + "/src/com/renho/sort/data.txt";
		int i = 0;
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		while(i < 100000) {
			i++;
			int temp = new Random().nextInt(999999999);
			System.out.println(temp);
			fw.write(temp + "\n");
		}
		fw.flush();
		fw.close();
		System.out.println(fileName);
		long end = System.currentTimeMillis();
		System.out.println("运行时间:" + (end - start));
	}
}
