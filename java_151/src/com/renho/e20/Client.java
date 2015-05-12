package com.renho.e20;


/**
 * 
 * 引用常量
 * 反编译class会发现
 * System.out.println("人类寿命极限是：180");
 * 是常量非引用
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("人类寿命极限是：" + Constant.MAX_AGE);
	}
}
