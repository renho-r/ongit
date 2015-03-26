package com.renho.custom;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {
	public static void main(String[] args) throws MalformedURLException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		URL url = new URL("file:/E:\\renho\\workspace\\ongit\\classloader");
		ClassLoader myloader = new URLClassLoader(new URL[] { url });
		Class c = myloader.loadClass("com.renho.custom.Test3");
		System.out.println("----------");
		//Test3 t3 = (Test3) c.newInstance();
		Object object = c.newInstance();
		SuperTest st = (SuperTest) object;
		st.renho();
	}
}