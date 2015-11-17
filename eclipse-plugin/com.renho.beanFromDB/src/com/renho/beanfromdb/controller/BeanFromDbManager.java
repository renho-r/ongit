package com.renho.beanfromdb.controller;

import java.io.File;
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

import com.renho.beanfromdb.Activator;
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
			File xmlFile = Activator.getDefault().getStateLocation().append("dbconfig.xml").toFile();
			reader = new FileReader(xmlFile);
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
			File xmlFile = Activator.getDefault().getStateLocation().append("dbconfig.xml").toFile();
			writer = new FileWriter(xmlFile);
			memento.save(writer);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(writer != null)
					writer.close();
			}catch(IOException e){
				
			}
		}
	}
	
	public void deleteDbConfig(DBViewSuperBean[] items) {
		if(dbViewSuperBeans == null) {
			loadDbConfig();
		}
		if(dbViewSuperBeans.removeAll(Arrays.asList(items))) {
			fireDbConfigChanged(DBViewSuperBean.NONE, items, DBViewSuperBean.NONE);
		}
		if(null == memento) {
			memento = DbConfigMemento.createWriteRoot("renho");			
		}
		deleteDescriptions(memento, items);
		FileWriter writer = null;
		try{
			File xmlFile = Activator.getDefault().getStateLocation().append("dbconfig.xml").toFile();
			writer = new FileWriter(xmlFile);
			memento.save(writer);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(writer != null)
					writer.close();
			}catch(IOException e){
				
			}
		}
	}
	
	private void deleteDescriptions(IMemento memento, DBViewSuperBean[] items){
		for(DBViewSuperBean dvsb:items) {
			memento = ((DbConfigMemento)memento).deleteChildren(dvsb.getTitle());
			System.out.println(11111);
		}
	}
	
	private void saveDescriptions(IMemento memento, DBViewSuperBean[] items){
		
		for(DBViewSuperBean dvs:items) {
			if(dvs instanceof DBConfig) {
				DBConfig dbConfig = (DBConfig) dvs;
				IMemento child = memento.createChild("dbconfig");
				child.putString("title", dbConfig.getTitle());
				child.putString("desc", dbConfig.getDescription());
				child.putString("url", dbConfig.getUrl());
				child.putString("user", dbConfig.getUser());
				child.putString("password", dbConfig.getPassword());				
			}
			
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
