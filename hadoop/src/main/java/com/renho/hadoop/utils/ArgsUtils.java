package com.renho.hadoop.utils;

import java.io.IOException;
import java.util.Properties;

public class ArgsUtils {

	public static String[] initArgs(String name) {
		String[] args = new String[2];
		Properties pro = new Properties();
		try {
			pro.load(Class.class.getResourceAsStream("/args.properties"));
			String args0 = pro.getProperty(name + "_args0");
			String args1 = pro.getProperty(name + "_args1");
			
			args[0] = args0;
			args[1] = args1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return args;
	}
}
