package com.renho.beanfromdb.controller;

import java.util.EventObject;

import com.renho.beanfromdb.modal.DBViewSuperBean;

public class BeanFromDbManagerEvent extends EventObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3593257924686815924L;

	private final DBViewSuperBean[] added;
	private final DBViewSuperBean[] removed;
	private final DBViewSuperBean[] modified;
	private final Object parentElement;

	public BeanFromDbManagerEvent(BeanFromDbManager source, DBViewSuperBean[] itemsAdded,
			DBViewSuperBean[] itemsRemoved, DBViewSuperBean[] itemsModified) {
		this(source, itemsAdded, itemsRemoved, itemsModified, null);
	}

	public BeanFromDbManagerEvent(BeanFromDbManager source, DBViewSuperBean[] itemsAdded,
			DBViewSuperBean[] itemsRemoved, DBViewSuperBean[] itemsModified, Object parentElement0) {
		super(source);
		added = itemsAdded;
		removed = itemsRemoved;
		modified = itemsModified;
		parentElement = parentElement0;
	}

	public DBViewSuperBean[] getItemsAdded() {
		return added;
	}

	public DBViewSuperBean[] getItemsRemoved() {
		return removed;
	}

	public DBViewSuperBean[] getItemsModified() {
		return modified;
	}

	public Object getParentElement() {
		return parentElement;
	}
	
}
