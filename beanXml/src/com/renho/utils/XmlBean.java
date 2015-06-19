package com.renho.utils;

import java.util.Iterator;
import java.util.List;

public class XmlBean {
	
	private Tables tables;
	
	public Tables getTables() {
		return tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	public String getQuerySql() {
		StringBuilder fieldBuilder = new StringBuilder();
		StringBuilder tableBuilder = new StringBuilder();
		Iterator<Table> tableIt = this.tables.getTables().iterator();
		while(tableIt.hasNext()) {
			Table table = tableIt.next();
			String tableName = table.getName();
			Iterator<Field> it = table.getFields().iterator();
			while(it.hasNext()) {
				Field field = it.next();
				fieldBuilder.append(tableName);
				fieldBuilder.append(".");
				fieldBuilder.append(field.getColumn());
				if(it.hasNext()) {
					fieldBuilder.append(", ");
				}
			}
			tableBuilder.append(tableName);
			if(tableIt.hasNext()) {
				tableBuilder.append(", ");
				fieldBuilder.append(", ");
			}
		}
		StringBuilder querySql = new StringBuilder();
		querySql.append("SELECT ");
		querySql.append(fieldBuilder.toString());
		querySql.append(" FROM ");
		querySql.append(tableBuilder.toString());
		if(null != this.tables.filter && !"".equals(this.tables.filter)) {
			querySql.append(" WHERE ");
			querySql.append(this.tables.getFilter());			
		}
		querySql.append(" ");
		return querySql.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static class Tables {
		
		private List<Table> tables;
		private String filter;
		
		public String getFilter() {
			return filter;
		}

		public void setFilter(String filter) {
			this.filter = filter;
		}

		public List<Table> getTables() {
			return tables;
		}

		public void setTables(List<Table> tables) {
			this.tables = tables;
		}
		
	}
	
	public static class Table {
		
		private String id;
		private String name;
		private List<Field> fields;
		private String filter;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<Field> getFields() {
			return fields;
		}
		public void setFields(List<Field> fields) {
			this.fields = fields;
		}
		public String getFilter() {
			return filter;
		}
		public void setFilter(String filter) {
			this.filter = filter;
		}
		
	}
	
	public static class Field {
		
		private String id;
		private String column;
		private Integer length;
		private Boolean orderAble;
		private String type;
		private Boolean pk;
		private Integer orderIndex;
		private String orderType;
		
		public Integer getOrderIndex() {
			return orderIndex;
		}
		public void setOrderIndex(Integer orderIndex) {
			this.orderIndex = orderIndex;
		}
		public String getOrderType() {
			return orderType;
		}
		public void setOrderType(String orderType) {
			this.orderType = orderType;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getColumn() {
			return column;
		}
		public void setColumn(String column) {
			this.column = column;
		}
		public Integer getLength() {
			return length;
		}
		public void setLength(Integer length) {
			this.length = length;
		}
		public Boolean getOrderAble() {
			return orderAble;
		}
		public void setOrderAble(Boolean orderAble) {
			this.orderAble = orderAble;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Boolean getPk() {
			return pk;
		}
		public void setPk(Boolean pk) {
			this.pk = pk;
		}
		
	}
	
}
