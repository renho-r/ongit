package com.renho.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) throws IOException {
		URL url;
		try {
			url = new URL("file:/E:\\renho\\workspace\\ongit\\classloader");
			Class clazz = null;
			
			
			try {
				clazz = Class.forName("com.renho.test.Test3");
				Object object = clazz.newInstance();
				SuperTest st = (SuperTest) object;
				st.renho();
				System.out.println("clazz1" + clazz);
			} catch (ClassNotFoundException e) {
				System.out.println("first not found");
			}
			
			
			getFile();
			
			try {
				clazz = Class.forName("com.renho.test.Test3");
				System.out.println("clazz2" + clazz);
			} catch (ClassNotFoundException e) {
				System.out.println("second not found");
			}
			
			
			ClassLoader urlLoader = new URLClassLoader(new URL[] { url });
			Class c = urlLoader.loadClass("com.renho.test.Test3");
			try {
				clazz = Class.forName("com.renho.test.Test3");
				System.out.println("clazz3" + clazz);
			} catch (ClassNotFoundException e) {
				System.out.println("Third not found");
			}
			
			
			System.out.println("----------");
			//Test3 t3 = (Test3) c.newInstance();
			Object object = c.newInstance();
			SuperTest st = (SuperTest) object;
			st.renho();
			System.out.println(">>>>>>>>>>>>>>>>>>11111<<<<<<<<<<<<<<<<<<");
			MyClassLoaderU myLoader = new MyClassLoaderU("E:\\renho\\workspace\\ongit\\classloader");
			try {
				Class myLoaderC = myLoader.loadClass("com.renho.test.Test3", 1);
				Object myLoaderCObject = myLoaderC.newInstance();
				SuperTest st0 = (SuperTest) myLoaderCObject;
				st0.renho();
				System.out.println("clazz3" + clazz);
			} catch (ClassNotFoundException e) {
				System.out.println("Third not found");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFile() throws IOException {
		File sourceFile = new File("E:\\Test3.class");
		File toFile = new File("E:\\renho\\workspace\\ongit\\classloader\\bin\\com\\renho\\test\\Test3.class");
		
		InputStream in = new FileInputStream(sourceFile);
		OutputStream out = new FileOutputStream(toFile);
		byte[] temp = new byte[1024];
		int len;
		while(-1 != (len=in.read(temp))) {
			System.out.println(len);
			out.write(temp, 0, len);
		}
		out.flush();
		out.close();
		
		in.close();
	}
}