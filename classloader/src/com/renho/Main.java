package com.renho;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		/*for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}*/
		Main main = new Main();
		Class c = main.getClass();
		ClassLoader cl = c.getClassLoader();
		System.out.println(cl.toString());
		System.out.println(cl.getParent());
		System.out.println(cl.getParent().getParent());
	}

}
