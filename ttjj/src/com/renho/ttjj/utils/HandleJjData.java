package com.renho.ttjj.utils;

import com.renho.ttjj.task.MonitorConfig;

import net.sf.json.JSONObject;

public class HandleJjData {

	public static void handle(MonitorConfig mc, String jsonData) {
		JSONObject jo = format(jsonData);
		Log.logger.log(jo.toString());
	}

	public static JSONObject format(String jsonData) {
		jsonData = jsonData.substring(jsonData.indexOf("{"), jsonData.lastIndexOf("}")+1);
		return JSONObject.fromObject(jsonData);
	}
	
}
