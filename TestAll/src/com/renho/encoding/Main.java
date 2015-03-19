package com.renho.encoding;

import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = new String("中文");
		
		byte[] bytes0 = s.getBytes("UTF-8");
		byte[] bytes1 = s.getBytes("GBK");
		byte[] bytes2 = s.getBytes("gb2312");
		byte[] bytes3 = s.getBytes("UTF-16");
		byte[] bytes4 = s.getBytes("ISO-8859-1");
		
		System.out.println(bytes0);
		System.out.println(bytes1);
		System.out.println(bytes2);
		System.out.println(bytes3);
		System.out.println(bytes4);
		
		String s0 = new String(bytes0, "UTF-8");
		String s1 = new String(bytes0, "GBK");
		String s2 = new String(bytes0, "gb2312");
		String s3 = new String(bytes0, "UTF-16");
		String s4 = new String(bytes0, "ISO-8859-1");
		
		System.out.println("s0:" + s0);
		System.out.println("s1:" + s1);
		System.out.println("s2:" + s2);
		System.out.println("s3:" + s3);
		System.out.println("s4:" + s4);
		
		String s10 = new String(bytes1, "UTF-8");
		String s11 = new String(bytes1, "GBK");
		String s12 = new String(bytes1, "gb2312");
		String s13 = new String(bytes1, "UTF-16");
		String s14 = new String(bytes1, "ISO-8859-1");
		
		System.out.println("s10:" + s10);
		System.out.println("s11:" + s11);
		System.out.println("s12:" + s12);
		System.out.println("s13:" + s13);
		System.out.println("s14:" + s14);
		
		String s20 = new String(bytes2, "UTF-8");
		String s21 = new String(bytes2, "GBK");
		String s22 = new String(bytes2, "gb2312");
		String s23 = new String(bytes2, "UTF-16");
		String s24 = new String(bytes2, "ISO-8859-1");
		
		System.out.println("s20:" + s20);
		System.out.println("s21:" + s21);
		System.out.println("s22:" + s22);
		System.out.println("s23:" + s23);
		System.out.println("s24:" + s24);
		
		String s30 = new String(bytes3, "UTF-8");
		String s31 = new String(bytes3, "GBK");
		String s32 = new String(bytes3, "gb2312");
		String s33 = new String(bytes3, "UTF-16");
		String s34 = new String(bytes3, "ISO-8859-1");
		
		System.out.println("s30:" + s30);
		System.out.println("s31:" + s31);
		System.out.println("s32:" + s32);
		System.out.println("s33:" + s33);
		System.out.println("s34:" + s34);
		
	}

}
