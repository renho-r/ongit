package com.renho.ttjj.utils;

public class Config {
	
	public static final String DATA_PATH = "/home/renho/javajj/jjdata.txt";
    public static final String DATA_PATH_CUS;
    static {
        DATA_PATH_CUS = System.getProperty("DATA_PATH");
    }
    
}
