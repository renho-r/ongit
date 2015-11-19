package com.renho.beanfromdb.modal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.IActionFilter;

public class DBViewSuperBean implements IActionFilter {

	protected String title;
	private List<DBViewSuperBean> children = new ArrayList<DBViewSuperBean>();
	private Object parent = new Object();
	public static DBViewSuperBean[] NONE = new DBViewSuperBean[]{};
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<DBViewSuperBean> getChildren() {
		return children;
	}

	public void setChildren(List<DBViewSuperBean> children) {
		this.children = children;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	@Override
	public boolean testAttribute(Object target, String name, String value) {
		
		return true;
	}
}
