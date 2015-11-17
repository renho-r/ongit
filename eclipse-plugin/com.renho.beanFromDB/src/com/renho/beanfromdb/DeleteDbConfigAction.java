package com.renho.beanfromdb;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.views.BeanFromDbView;

public class DeleteDbConfigAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public DeleteDbConfigAction() {
		
	}

	@Override
	public void run(IAction action) {
		BeanFromDbView beanFromDbView = (BeanFromDbView)targetPart;
		DBViewSuperBean[] selected = beanFromDbView.getSelectedDbConfig();
		BeanFromDbManager.getBeanFromDbManager().deleteDbConfig(selected);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

}
