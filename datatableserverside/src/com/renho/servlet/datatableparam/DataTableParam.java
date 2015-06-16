package com.renho.servlet.datatableparam;

import java.util.List;

import net.sf.json.JSONObject;

public class DataTableParam {

	private List<Columns> columns;
	private List<Order> order;
	private Search search;
	private Integer draw;
	private Integer start;
	private Integer length;
	private JSONObject paramJson;
	
	public Object get(Object key) {
		return this.paramJson.get(key);
	}
	
	public JSONObject getParamJson() {
		return paramJson;
	}

	public void setParamJson(JSONObject paramJson) {
		this.paramJson = paramJson;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public List<Columns> getColumns() {
		return columns;
	}

	public void setColumns(List<Columns> columns) {
		this.columns = columns;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}
}