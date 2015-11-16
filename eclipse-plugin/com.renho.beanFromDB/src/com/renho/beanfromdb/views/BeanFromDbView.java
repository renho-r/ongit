package com.renho.beanfromdb.views;

import java.util.Iterator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.*;

import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.views.provider.ViewContentProvider;
import com.renho.beanfromdb.views.provider.ViewLabelProvider;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.SWT;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class BeanFromDbView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "com.renho.beanfromdb.views.BeanFromDbView";
	public ViewContentProvider viewContentProvider;
	
	private TreeViewer viewer;
	
	/**
	 * The constructor.
	 */
	public BeanFromDbView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.SINGLE);
		viewContentProvider = new ViewContentProvider();
		viewer.setContentProvider(viewContentProvider);
		
		ViewLabelProvider vlp = new ViewLabelProvider();
		viewer.setLabelProvider(vlp);
		viewer.setInput(getViewSite());
		
		//初始化弹出菜单  
        MenuManager popupMenuManager = new MenuManager("#PopupMenu");  
        popupMenuManager.setRemoveAllWhenShown(true);  
        Menu popupMenu = popupMenuManager.createContextMenu(viewer.getTree());  
        viewer.getTree().setMenu(popupMenu);  
        //设置选择提供者和弹出菜单  
        getSite().setSelectionProvider(viewer);  
        getSite().registerContextMenu(popupMenuManager, viewer);  
	}
	
	public DBViewSuperBean[] getSelectedDbConfig() {
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		DBViewSuperBean[] items = new DBViewSuperBean[selection.size()];
		Iterator iter = selection.iterator();
		int index = 0;
		while(iter.hasNext())
			items[index++] = (DBViewSuperBean)iter.next();
		return items;
	}
	
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public TreeViewer getViewer() {
		return viewer;
	}

	public void setViewer(TreeViewer viewer) {
		this.viewer = viewer;
	}
}