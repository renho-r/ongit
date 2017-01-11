package com.renho.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

	public static void main(String[] args) throws IOException {
		String fileName = "C:/Users/renho/Desktop/temp/2016/09/12/15/PSRF_TOP_1_16.data";
		File dataFile = new File(fileName);
		RandomAccessFile raf = new RandomAccessFile(dataFile, "r");
		System.out.println(raf.length());
		byte[] dataBytes = new byte[(int) raf.length()];
		raf.read(dataBytes);
		raf.close();
		String dataStr = new String(dataBytes);
		
		BufferedReader br = new BufferedReader(new StringReader(dataStr));
		String line = null;
		Pattern topPattern = Pattern.compile("^Top (\\d*) (.*) ordered by (.*):.*");
		Pattern summaryPattern = Pattern.compile("^Summary.*");
		TopStru topStru = null;
		List<String> tempData = new ArrayList<>();
		while(null != (line = br.readLine())) {
			Matcher topMatcher = topPattern.matcher(line);
			Matcher summaryMatcher = summaryPattern.matcher(line);
			if(topMatcher.find()) {
				process(tempData, topStru);
				tempData.clear();
				topStru = new TopStru(topMatcher.group(1), topMatcher.group(2), topMatcher.group(3));
				System.out.println("½âÎö:" + topStru.topCount + "->" + topStru.groupBy + "->" + topStru.orderBy);
			} else if(summaryMatcher.matches()) {
				process(tempData, topStru);
				tempData.clear();
				tempData.add(line);
			}else {
				tempData.add(line);
			}
		}
		System.out.println("½âÎö:Summary");
		process(tempData);
	}
	
	private static void process(List<String> data) {
		data.forEach(System.out::println);
	}

	private static void process(List<String> data, TopStru topStru) {
		if(null != topStru && !topStru.isEmpty()) {
			data.forEach(System.out::println);			
			System.out.println(topStru.topCount);
		}
	}

	private static class TopStru {
		private String topCount;
		private String groupBy;
		private String orderBy;
		private TopStru(String topCount, String groupBy, String orderBy) {
			super();
			this.topCount = topCount;
			this.groupBy = groupBy;
			this.orderBy = orderBy;
		}
		private boolean isEmpty() {
			if((null==topCount || "".equals(topCount)) && (null==groupBy || "".equals(groupBy)) && (null==orderBy || "".equals(orderBy))) {
				return true;
			}
			return false;
		}
	}
	
}
