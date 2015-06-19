package com.renho.json;

import java.util.List;

import com.renho.json.pojo.DataTableParam;
import com.renho.json.pojo.DataTableParam.Columns;

import net.sf.json.JSONObject;

public class Client {

	public static void main(String[] args) {
		String jsonStr = JsonFileUtil.getJsonString();
		JSONObject json = JSONObject.fromObject(jsonStr);
		DataTableParam dtp = DataTableParamUtil.fromJson(json);
		List<Columns> columnsList = dtp.getColumns();
		for(Columns columns:columnsList) {
			System.out.println(columns.getOrderable());
		}
		dtp.put("testKey", "testValue");
		System.out.println(dtp.get("testKey"));
	}

}
