package com.renho.ttjj.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class JjCodeUtils {
	
	private static final List<String> codes = new ArrayList<>();
	
	public static List<String> getJjCodes() {
		return codes;
	}
	
	public static void initCodes() {
		try {
			String js = HttpClientUtils.getJjInfo("http://fund.eastmoney.com/js/fundcode_search.js");
			String codesJson = js.substring(js.indexOf("["), js.lastIndexOf("]")+1);
			JSONArray jas = JSONArray.fromObject(codesJson);
			for(Object obj:jas) {
				JSONArray ja = (JSONArray) obj;
				codes.add(ja.getString(0));
			}
		} catch (Exception e) {
		}
	}
}
