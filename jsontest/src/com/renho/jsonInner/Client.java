package com.renho.jsonInner;

import com.renho.jsonInner.pojo.DataTableParam;

import net.sf.json.JSONObject;

public class Client {

	public static void main(String[] args) {
		String jsonStr = JsonFileUtil.getJsonString();
		
		JSONObject json = JSONObject.fromObject(jsonStr);
		DataTableParam dtp = DataTableParamUtil.fromJson(json);
		System.out.println(1);
//		DataTableParam dtp = new DataTableParam();
//		dtp.setDraw(0);
//		dtp.setLength(1);
//		dtp.setStart(2);
//		List<Columns> columnsList = new ArrayList<DataTableParam.Columns>();
//		for(int i=0; i<10; i++) {
//			Columns c = dtp.new Columns();
//			c.setName("renho" + i);
//			columnsList.add(c);
//		}
//		dtp.setColumns(columnsList);
//		for(Columns c:columnsList) {
//			System.out.println(c.getName());
//			c.showOuterInfo();
//		}
	}

}
