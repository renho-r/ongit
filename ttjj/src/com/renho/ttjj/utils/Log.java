package com.renho.ttjj.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public enum Log {
	
	logger;
	
	public void log(String data) {
		synchronized(this) {
			try {
				FileWriter fw = new FileWriter(new File(Config.DATA_PATH), true);
				fw.write(data);
				fw.write("\n");
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
