package com.renho.morefile.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class HandleFile implements Callable<Double> {

	private String filePath = "D:\\testfile";
	private int c;
	
	public HandleFile(int c) {
		this.c = c;
	}
	@Override
	public Double call() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath + "/r" + c + "/renho.txt")));
		String rd;
		BigDecimal n, sum = new BigDecimal(0);
		long l = 0L;
		while(null != (rd=br.readLine())) {
			n = new BigDecimal(Integer.valueOf(rd));
			sum = sum.add(n);
			l++;
		}
		br.close();
		BigDecimal d = sum.divide(new BigDecimal(l));
		return d.doubleValue();
	}

}
