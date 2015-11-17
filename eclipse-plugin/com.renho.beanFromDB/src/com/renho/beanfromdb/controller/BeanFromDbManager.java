package com.renho.beanfromdb.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.internal.ViewSite;

import com.renho.beanfromdb.modal.BeanFromDbManagerListener;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.DbConfigMemento;

@SuppressWarnings("restriction")
public class BeanFromDbManager {
	private DbConfigMemento memento;
	private List<BeanFromDbManagerListener> listeners = new ArrayList<>();
	private Collection<DBViewSuperBean> dbViewSuperBeans;
	private static BeanFromDbManager manager;
	private ViewSite viewSite;
	
	private BeanFromDbManager() {
		init();
	}
	
	private void init() {
		loadDbConfig();
	}

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
		if(null == dbViewSuperBeans) {
			dbViewSuperBeans = new ArrayList<>();
		}
		return (DBViewSuperBean[])dbViewSuperBeans.toArray(new DBViewSuperBean[dbViewSuperBeans.size()]);
	}

	private void loadDbConfig() {
		
		FileReader reader = null;
		try {
			reader = new FileReader("c:/renho/renho.xml");
			memento = DbConfigMemento.createReadRoot(reader);
			loadDescriptions();
		} catch (FileNotFoundException e) {
			// initFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
			// to be added
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// to be added
			}
		}
		
//		dbViewSuperBeans = new ArrayList<>();
//		DBConfig dbConfig0 = new DBConfig("name0", "description0", "jdbc:mysql://localhost:3306/test", "root", "root123");
//		DBConfig dbConfig1 = new DBConfig("name1", "description1", "url1", "user1", "password1");
//		DBConfig dbConfig2 = new DBConfig("name2", "description2", "url2", "user2", "password2");
//		DBConfig dbConfig3 = new DBConfig("name3", "description3", "url3", "user3", "password3");
//		
//		dbViewSuperBeans.add((DBViewSuperBean)dbConfig0);
//		dbViewSuperBeans.add((DBViewSuperBean)dbConfig1);
//		dbViewSuperBeans.add((DBViewSuperBean)dbConfig2);
//		dbViewSuperBeans.add((DBViewSuperBean)dbConfig3);
	}
	
	private void loadDescriptions() {
		IMemento[] listChildren = memento.getChildren("dbconfig");
		dbViewSuperBeans = new ArrayList<>();
		for(IMemento im:listChildren) {
			DBConfig dbConfig = new DBConfig(
					im.getString("title"), 
					im.getString("desc"), 
					im.getString("url"), 
					im.getString("user"),
					im.getString("password"));
			dbViewSuperBeans.add(dbConfig);
		}
	}

	public void addDbConfig(DBViewSuperBean[] items) {
		if(dbViewSuperBeans == null) {
			loadDbConfig();
		}
		if(dbViewSuperBeans.addAll(Arrays.asList(items))) {
			fireDbConfigChanged(items, DBViewSuperBean.NONE, DBViewSuperBean.NONE);
		}
		if(null == memento) {
			memento = DbConfigMemento.createWriteRoot("renho");			
		}
		saveDescriptions(memento, (DBConfig[]) items);
		FileWriter writer = null;
		try{
			writer = new FileWriter("c:/renho/renho.xml");
			memento.save(writer);
		}catch(IOException e){
		}finally{
			try{
				if(writer != null)
					writer.close();
			}catch(IOException e){
			}
		}
	}
	
	private void saveDescriptions(IMemento memento, DBConfig[] items){
		
		for(DBConfig dbConfig:items) {
			IMemento child = memento.createChild("dbconfig");
			child.putString("title", dbConfig.getTitle());
			child.putString("desc", dbConfig.getDescription());
			child.putString("url", dbConfig.getUrl());
			child.putString("user", dbConfig.getUser());
			child.putString("password", dbConfig.getPassword());
			
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
	
	public boolean checkOnlyDbName(String dbName) {
		for(DBViewSuperBean dsb:dbViewSuperBeans) {
			if(dsb instanceof DBConfig) {
				if(dbName.equals(dsb.getTitle())) {
					return false;
				}
			}
		}
		return true;
	}
	
}
