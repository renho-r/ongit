package com.renho.chapter1.e4;

import java.util.concurrent.TimeUnit;

public class Client {

	public static void main(String[] args) {
		FileSearch fs = new FileSearch("c:\\", "autoexec.bat");
		Thread searchTask = new Thread(fs);
		searchTask.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		searchTask.interrupt();
	}

}
