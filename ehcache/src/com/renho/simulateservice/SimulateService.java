package com.renho.simulateservice;

import com.renho.dao.SimulateDAO;

public class SimulateService {

	public String getTime() {
		SimulateDAO sd = new SimulateDAO();
		return sd.getTime();
	}
	
}
