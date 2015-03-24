package com.renho.timer;

import java.util.Date;
import java.util.Timer;

import org.apache.commons.lang.time.DateFormatUtils;

public class Test {
	public static void main(String[] args) {
		Timer timer = new Timer();
		System.out.println("init:" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss:SSS"));
		timer.schedule(new TimerTaskTest(), 1000, 5000);
	}
}
