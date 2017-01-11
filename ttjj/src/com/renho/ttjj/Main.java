package com.renho.ttjj;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;

import com.renho.ttjj.task.Monitor;
import com.renho.ttjj.task.MonitorConfig;
import com.renho.ttjj.utils.JjCodeUtils;


public class Main {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String param = args[0];
		switch(param) {
			case "start":
				init();
				start();
				break;
			default:
				break;
		}
	}
	
	public static void start() {
		List<String> list = JjCodeUtils.getJjCodes();
		
		ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);
		for(String code: list) {
			MonitorConfig mc = new MonitorConfig(code);
			Runnable task = new Monitor(mc);
			executors.scheduleAtFixedRate(task, 1, 60, TimeUnit.SECONDS);
		}
	}
	
	public static void init() {
		JjCodeUtils.initCodes();
	}
}
