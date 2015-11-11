package com.renho.beanfromdb.views;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.part.*;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.SWT;

import com.renho.beanfromdb.views.bean.DBConfig;
import com.renho.beanfromdb.views.bean.DBInstance;
import com.renho.beanfromdb.views.bean.DBViewSuperBean;


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

	private TreeViewer viewer;
	
	class ViewContentProvider extends ArrayContentProvider implements ITreeContentProvider{

		@Override
        public Object[] getChildren(Object parentElement) {
        	DBViewSuperBean dbViewSuperBean = (DBViewSuperBean)parentElement;
            return dbViewSuperBean.getChildren().toArray();
        }

        @Override
        public Object getParent(Object element) {
        	DBViewSuperBean dbViewSuperBean = (DBViewSuperBean)element;
            return dbViewSuperBean.getParent();
        }

        @Override
        public boolean hasChildren(Object element) {
        	DBViewSuperBean dbViewSuperBean = (DBViewSuperBean)element;
            return dbViewSuperBean.getChildren().size()>0?true:false;
        }
        
        @Override
        public Object[] getElements(Object inputElement) {
        	DBConfig[] dbConfigs = new DBConfig[2];
			dbConfigs[0] = new DBConfig();
			dbConfigs[0].setIp("127.0.0.1");
			dbConfigs[0].setPort("3306");
			dbConfigs[0].setUserName("root");
			dbConfigs[0].setPwd("root123");
			dbConfigs[0].setTitle("localhost");
			List<DBViewSuperBean> list = new ArrayList<DBViewSuperBean>();
			DBInstance dbInstance = new DBInstance();
			dbInstance.setTitle("dev_dnsdb65");
			list.add(dbInstance);
			dbConfigs[0].setChildren(list);
			
			dbConfigs[1] = new DBConfig();
			dbConfigs[1].setIp("127.0.0.1");
			dbConfigs[1].setPort("3306");
			dbConfigs[1].setUserName("root");
			dbConfigs[1].setPwd("root123");
			dbConfigs[1].setTitle("245");
			
			List<DBViewSuperBean> list1 = new ArrayList<DBViewSuperBean>();
			DBInstance dbInstance1 = new DBInstance();
			dbInstance1.setTitle("dev_dnsdb65");
			list.add(dbInstance1);
			
			dbConfigs[1].setChildren(list1);
			return dbConfigs;
        }
        
    }

	class ViewLabelProvider extends LabelProvider {
		@Override
		public String getText(Object obj) {
			return ((DBViewSuperBean)obj).getTitle();
		}

		@Override
		public Image getImage(Object obj) {
			return null;
		}
	}
	
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
		viewer.setContentProvider(new ViewContentProvider());
		
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
	
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}