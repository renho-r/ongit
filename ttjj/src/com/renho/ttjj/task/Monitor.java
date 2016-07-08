package com.renho.ttjj.task;

import com.renho.ttjj.utils.HandleJjData;
import com.renho.ttjj.utils.HttpClientUtils;

public class Monitor implements Runnable {

	private MonitorConfig mc;
	private boolean exeFlag = true;
	
	public Monitor(MonitorConfig mc) {
		this.mc = mc;
	}
	
	@Override
	public void run() {
		if(exeFlag) {
			try {
				String jsonStr = HttpClientUtils.getJjInfo(mc.getUrl());
				HandleJjData.handle(mc, jsonStr);
			} catch (Exception e) {
				exeFlag = false;
			}			
		}
	}
}
