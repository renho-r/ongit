package com.renho.diffloadmethod;

public class DiffLoadMethod {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = DiffLoadMethod.class.getClassLoader();
		System.out.println(loader);
		// 使用ClassLoader.loadClass()来加载类，不会执行初始化块
		//loader.loadClass("com.renho.diffloadmethod.Test2");
		// 使用Class.forName()来加载类，默认会执行初始化块
		//Class.forName("com.renho.diffloadmethod.Test2");
		// 使用Class.forName()来加载类，并指定ClassLoader，初始化时通过第二个参数控制执行静态块
		//Class.forName("com.renho.diffloadmethod.Test2", false, loader);
	}
}
