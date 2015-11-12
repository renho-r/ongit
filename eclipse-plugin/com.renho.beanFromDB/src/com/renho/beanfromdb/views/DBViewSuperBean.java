package com.renho.beanfromdb.views;

import java.util.ArrayList;
import java.util.List;

public class DBViewSuperBean {

	protected String title;
	private List<Object> children = new ArrayList<Object>();
	private Object parent;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Object> getChildren() {
		return children;
	}

	public void setChildren(List<Object> children) {
		this.children = children;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}
}
