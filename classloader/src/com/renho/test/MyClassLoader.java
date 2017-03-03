package com.renho.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;

import com.renho.test.other.ShowClassTest3;

public class MyClassLoader {
	
	public static MyClassLoaderU myLoader = new MyClassLoaderU("E:\\renho\\workspace\\ongit\\classloader");
	
	@SuppressWarnings({ "resource", "rawtypes" })
	public static void main(String[] args) throws IOException {
		try {
			MyClassLoaderU myLoaderTemp = new MyClassLoaderU("E:\\renho\\workspace\\ongit\\classloader");
			myLoaderTemp.loadClass("com.renho.test.Test3", 1);
			myLoader = myLoaderTemp;			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Thread t = new Thread(new ShowClassTest3());
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
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
			
			
			getFile("E:\\a\\Test3.class");
			
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
			Object object = c.newInstance();
			SuperTest st = (SuperTest) object;
			st.renho();
			System.out.println(">>>>>>>>>>>>>>>>>>after load a<<<<<<<<<<<<<<<<<<");
			try {
				MyClassLoaderU myLoaderTemp = new MyClassLoaderU("E:\\renho\\workspace\\ongit\\classloader");
				Class myLoaderC = myLoaderTemp.loadClass("com.renho.test.Test3", 1);
				Object myLoaderCObject = myLoaderC.newInstance();
				SuperTest st0 = (SuperTest) myLoaderCObject;
				st0.renho();
				System.out.println("clazz3" + clazz);
				myLoader = myLoaderTemp;
			} catch (ClassNotFoundException e) {
				System.out.println("Third not found");
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			getFile("E:\\b\\Test3.class");
			System.out.println(">>>>>>>>>>>>>>>>>>after load b<<<<<<<<<<<<<<<<<<");
			clazz = null;
			try {
				MyClassLoaderU myLoaderTemp = new MyClassLoaderU("E:\\renho\\workspace\\ongit\\classloader");
				Class myLoaderC = myLoaderTemp.loadClass("com.renho.test.Test3", 1);
				Object myLoaderCObject = myLoaderC.newInstance();
				SuperTest st0 = (SuperTest) myLoaderCObject;
				st0.renho();
				System.out.println("clazz3" + clazz);
				myLoader = myLoaderTemp;
			} catch (ClassNotFoundException e) {
				System.out.println("Third not found");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static void getFile(String path) throws IOException {
		File sourceFile = new File(path);
		File toFile = new File("E:\\renho\\workspace\\ongit\\classloader\\bin\\com\\renho\\test\\Test3.class");
		
		InputStream in = new FileInputStream(sourceFile);
		OutputStream out = new FileOutputStream(toFile);
		byte[] temp = new byte[1024];
		int len;
		while(-1 != (len=in.read(temp))) {
			out.write(temp, 0, len);
		}
		out.flush();
		out.close();
		
		in.close();
	}
}