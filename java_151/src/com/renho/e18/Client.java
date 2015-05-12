package com.renho.e18;

import java.util.Date;

/**
 * 避免instanceof非预期结果
 */
@SuppressWarnings("all")
public class Client {	
	public static void main(String[] args) {
		//String对象是否是Object的实例
		boolean b1 = "Sting" instanceof Object;
		//String对象是否是String的实例
		boolean b2 = new String() instanceof String;
		//Object对象是否是String的实例
		boolean b3 = new Object() instanceof String;
		//拆箱类型是否是装箱类型的实例
	//	boolean b4 = 'A' instanceof Character;
		//空对象是否是String的实例
		boolean b5 = null instanceof String;
		//类型转换后的空对象是否是String的实例
		boolean b6 = (String)null instanceof String;
		//Date对象是否是String的实例
	//	boolean b7 = new Date() instanceof String;
		//在泛型类中判断String对象是否是Date的实例
		boolean b8 = new GenericClass<String>().isDateInstance("");
		

	}
}

class GenericClass<T>{
	//判断是否是Date类型
	public boolean isDateInstance(T t){
		return t instanceof Date;
	}
}

