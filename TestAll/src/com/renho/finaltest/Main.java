/**   
* @Title: Main.java 
* @Package com.renho.finaltest 
* @Description: TODO
* @author renho   
* @date 2013年9月5日 下午4:17:39 
* @version V1.0   
*/
package com.renho.finaltest;

public class Main {

	private final int F = 100;
	
	public static void main(String[] args) {
		/*System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());
		System.out.println(new Apple().getId());*/
//		System.out.println(new Apple().getCounter());
//		System.out.println(new Apple().getCounter());
//		System.out.println(new Apple().getCounter());
//		System.out.println(new Apple().getCounter());
//		System.out.println(new Apple().getCounter());
		Apple apple = new Apple();
		Apple apple2 = new Apple();
		System.out.println(apple.getCounter());
		System.out.println(apple2.getCounter());
		System.out.println(apple.getId());
		System.out.println(apple2.getId());
		
		test();
	}

	public static void test() {
		/*System.out.println(new Apple().getId());*/
	}
	
}

