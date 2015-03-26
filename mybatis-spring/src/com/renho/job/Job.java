package com.renho.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Job {

	public void doJob() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(calendar.getTime()));
	}
}
