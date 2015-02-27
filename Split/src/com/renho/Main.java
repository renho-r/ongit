package com.renho;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String renho = "1.renho";
		String[] x = renho.split("\\.");
		System.out.println(x.length);
		for(String s:x) {
			System.out.println(s);
		}
	}

}
