package com.renho.beanfromdb.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
public class DBView extends ViewPart {

	public static final String ID = "com.renho.beanfromdb.views.DBView";

	private TreeViewer viewer;
	private Action openDBAction;

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
			List<Object> list = new ArrayList<Object>();
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
			
			List<Object> list1 = new ArrayList<Object>();
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

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public DBView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.SINGLE);
		viewer.setContentProvider(new ViewContentProvider());
		
		ViewLabelProvider vlp = new ViewLabelProvider();
		viewer.setLabelProvider(vlp);
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		makeActions();
		hookContextMenu();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DBView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(openDBAction);
		//manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void makeActions() {
		openDBAction = new Action() {
			public void run() {
			}
		};
		openDBAction.setText("Open DB");
	}
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}