package com.renho;

public class Client {

	public static void main(String[] args) {
		
		Integer a = 100;
		Integer b = 100;
		System.out.println(a == b);
		
		Integer aa = 128;
		Integer bb = 128;
		System.out.println(aa == bb);
		
		int count = (int)2E31;
		System.out.println("(int)2E31:" + count);
		System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
		
		int x = (int) (2E31 - 1);
		System.out.println("(int) (2E31 - 1):" + x);
		
		int xx = (int)2E31 - 1;
		System.out.println("(int)2E31 - 1:" + xx);
		
		int countxx = (int) (2E31-1);
		System.out.println("(int) (2E31-1):" + countxx);
		
		double dd = 2147483648d;
		int dd2i = (int) dd;
		System.out.println(dd2i);
		
		short s = 128;
		byte s2b = (byte) s;
		System.out.println(s2b);
		
		System.out.println("(int)(2E31 + 1):" + (int)(2E31 + 1));
		//double类型转int,超过int最大值时转换成int最大值
		System.out.println("(int)(2E31 + 1):" + (int)(2E31 + 1000));
	}

}
