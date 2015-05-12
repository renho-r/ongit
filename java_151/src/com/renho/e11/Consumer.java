package com.renho.e11;

/**
 * 养成良好习惯，显式声明UID
 *
 */

public class Consumer {

	public static void main(String[] args) throws Exception {
		// 反序列化化
		Person p = (Person) SerializationUtils.readObject();
		System.out.println("name="+p.getName());
	}
}
