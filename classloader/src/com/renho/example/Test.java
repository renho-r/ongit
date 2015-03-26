package com.renho.example;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
	//sun.misc.Launcher$AppClassLoaderϵͳ�������
	//sun.misc.Launcher$ExtClassLoader��չ�������
	//bootstrap class loader ����������� ԭ�����룬���̳�ClassLoader
	public void testClassIdentity() {
		String classDataRootPath = "E:\\renho\\workspace\\ongit\\classloader";
		MyClassLoader fscl1 = new MyClassLoader(classDataRootPath);
		MyClassLoader fscl2 = new MyClassLoader(classDataRootPath);
		String className = "com.renho.example.Sample";
		try {
			Class<?> class1 = fscl1.loadClass(className, 0);
			Object obj1 = class1.newInstance();
			Class<?> class2 = fscl2.loadClass(className, 1);
			Object obj2 = class2.newInstance();
			System.out.println(obj1.getClass().equals(obj2.getClass()));
						
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			
			setSampleMethod.invoke(obj1, obj2);
			
			URL url = new URL("file:/E:\\renho\\workspace\\ongit\\classloader");
			ClassLoader myloader = new URLClassLoader(new URL[] { url });
			System.out.println(myloader.getParent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.testClassIdentity();
	}
}
