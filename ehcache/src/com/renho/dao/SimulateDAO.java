package com.renho.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimulateDAO {

	public String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
}
