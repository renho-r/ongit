package com.renho.beanfromdb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.internal.ViewSite;

import com.renho.beanfromdb.modal.BeanFromDbManagerListener;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;

@SuppressWarnings("restriction")
public class BeanFromDbManager {
	
	private List<BeanFromDbManagerListener> listeners = new ArrayList<>();
	private Collection<DBViewSuperBean> dbViewSuperBeans;
	private static BeanFromDbManager manager;
	private ViewSite viewSite;
	
	private BeanFromDbManager() {}
	
	public static BeanFromDbManager getBeanFromDbManager() {
		if(null == manager) {
			manager = new BeanFromDbManager();
		}
		return manager;
	}
	
	public DBViewSuperBean[] getDbViews(){
		if(dbViewSuperBeans == null) {
			loadDbConfig();
		}
		return (DBViewSuperBean[])dbViewSuperBeans.toArray(new DBViewSuperBean[dbViewSuperBeans.size()]);
	}

	private void loadDbConfig() {
		dbViewSuperBeans = new HashSet<>();
		DBConfig dbConfig0 = new DBConfig("name0", "description0", "jdbc:mysql://localhost:3306/test", "root", "root123");
		DBConfig dbConfig1 = new DBConfig("name1", "description1", "url1", "user1", "password1");
		DBConfig dbConfig2 = new DBConfig("name2", "description2", "url2", "user2", "password2");
		DBConfig dbConfig3 = new DBConfig("name3", "description3", "url3", "user3", "password3");
		
		dbViewSuperBeans.add((DBViewSuperBean)dbConfig0);
		dbViewSuperBeans.add((DBViewSuperBean)dbConfig1);
		dbViewSuperBeans.add((DBViewSuperBean)dbConfig2);
		dbViewSuperBeans.add((DBViewSuperBean)dbConfig3);
	}
	
	public void addDbConfig(DBViewSuperBean[] items) {
		if(dbViewSuperBeans == null) {
			loadDbConfig();
		}
		if(dbViewSuperBeans.addAll(Arrays.asList(items))) {
			fireDbConfigChanged(items, DBViewSuperBean.NONE, DBViewSuperBean.NONE);
		}
	}
	
	public void addDbConfigTables(DBViewSuperBean[] items, Object parent) {
		if(dbViewSuperBeans == null) {
			loadDbConfig();
		}
		if(null != items) {
			((DBViewSuperBean)parent).setChildren(Arrays.asList(items));
			fireDbConfigTablesChanged(items, DBViewSuperBean.NONE, DBViewSuperBean.NONE, parent);
		}
	}
	
	private void fireDbConfigTablesChanged(DBViewSuperBean[] itemsAdded, DBViewSuperBean[] itemsRemoved, DBViewSuperBean[] itemsModified, Object parent){
		BeanFromDbManagerEvent event = new BeanFromDbManagerEvent( this, itemsAdded, itemsRemoved, itemsModified, parent);
		for(@SuppressWarnings("rawtypes")
		Iterator iter = listeners.iterator();iter.hasNext();) {
			((BeanFromDbManagerListener)iter.next()).dbConfigTablesChanged(event);
		}
	}
	
	private void fireDbConfigChanged(DBViewSuperBean[] itemsAdded, DBViewSuperBean[] itemsRemoved, DBViewSuperBean[] itemsModified){
		BeanFromDbManagerEvent event = new BeanFromDbManagerEvent( this, itemsAdded, itemsRemoved, itemsModified);
		for(@SuppressWarnings("rawtypes")
		Iterator iter = listeners.iterator();iter.hasNext();) {
			((BeanFromDbManagerListener)iter.next()).dbConfigChanged(event);
		}
	}

	public ViewSite getViewSite() {
		return viewSite;
	}

	public void setViewSite(ViewSite viewSite) {
		this.viewSite = viewSite;
	}

	public void removeDbConfigManagerListener(BeanFromDbManagerListener viewContentProvider) {
		listeners.remove(viewContentProvider);
	}

	public void addDbConfigManagerListener(BeanFromDbManagerListener viewContentProvider) {
		listeners.add(viewContentProvider);
	}
	
}
