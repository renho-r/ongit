package com.renho.timer;

import java.util.Date;
import java.util.TimerTask;

import org.apache.commons.lang.time.DateFormatUtils;

public class TimerTaskTest extends TimerTask {

	@Override
	public void run() {
		System.out.println("start:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss:SSS"));
	}
}
