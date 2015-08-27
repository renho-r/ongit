package com.renho.jsonInner.pojo;

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
	
	public class Columns {
		
		private Integer data;
		private String name;
		private Boolean searchable;
		private Boolean orderable;
		private Search search;

		public Columns() {}
		
		public Columns(String name) {
			this.name = name;
		}
		
		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Boolean getSearchable() {
			return searchable;
		}

		public void setSearchable(Boolean searchable) {
			this.searchable = searchable;
		}

		public Boolean getOrderable() {
			return orderable;
		}

		public void setOrderable(Boolean orderable) {
			this.orderable = orderable;
		}

		public Search getSearch() {
			return search;
		}

		public void setSearch(Search search) {
			this.search = search;
		}
		
		public void showOuterInfo() {
			System.out.println(draw + ":" + length + ":" + start);
		}
	}
	
	public class Order {

		private Integer column;
		private String dir;
		private String fieldName;
		
		public Integer getColumn() {
			return column;
		}
		public void setColumn(Integer column) {
			this.column = column;
		}
		public String getDir() {
			return dir;
		}
		public void setDir(String dir) {
			this.dir = dir;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		
	}
	
	public class Search {
		
		private String value;
		private Boolean regex;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Boolean getRegex() {
			return regex;
		}

		public void setRegex(Boolean regex) {
			this.regex = regex;
		}
	}
}