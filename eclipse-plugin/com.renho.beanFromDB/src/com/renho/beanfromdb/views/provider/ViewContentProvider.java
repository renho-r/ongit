package com.renho.beanfromdb.views.provider;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.internal.ViewSite;

import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.controller.BeanFromDbManagerEvent;
import com.renho.beanfromdb.modal.BeanFromDbManagerListener;
import com.renho.beanfromdb.modal.DBViewSuperBean;

@SuppressWarnings("restriction")
public class ViewContentProvider extends ArrayContentProvider implements ITreeContentProvider, BeanFromDbManagerListener {
	private TreeViewer viewer;
	private BeanFromDbManager manager = null;

	@Override
	public Object[] getChildren(Object parentElement) {
		DBViewSuperBean dbViewSuperBean = (DBViewSuperBean) parentElement;
		return dbViewSuperBean.getChildren().toArray();
	}

	@Override
	public Object getParent(Object element) {
		if (null == element || !(element instanceof DBViewSuperBean)) {
			return null;
		} else {
			DBViewSuperBean dbViewSuperBean = (DBViewSuperBean) element;
			return dbViewSuperBean.getParent();
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		DBViewSuperBean dbViewSuperBean = (DBViewSuperBean) element;
		return dbViewSuperBean.getChildren().size() > 0 ? true : false;
	}

	public void setElements(Object inputElement) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return manager.getDbViews();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		this.viewer = (TreeViewer)viewer;
		if(manager != null)
			manager.removeDbConfigManagerListener(this);
		manager = BeanFromDbManager.getBeanFromDbManager();
		if(manager != null) {
			manager.addDbConfigManagerListener(this);
		}
		manager.setViewSite((ViewSite)newInput);
	}

	@Override
	public void dbConfigChanged(BeanFromDbManagerEvent event) {
		this.viewer.add(manager.getViewSite(), event.getItemsAdded());
		this.viewer.remove(event.getItemsRemoved());
	}

	@Override
	public void dbConfigTablesChanged(BeanFromDbManagerEvent event) {
		this.viewer.remove(event.getParentElement(), ((DBViewSuperBean)event.getParentElement()).getChildren().toArray());
		this.viewer.collapseAll();
		this.viewer.add(event.getParentElement(), event.getItemsAdded());
	}

}