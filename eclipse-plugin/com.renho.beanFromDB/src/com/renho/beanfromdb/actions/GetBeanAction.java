package com.renho.beanfromdb.actions;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.views.BeanFromDbView;
import com.renho.beanfromdb.wizard.ExportNewWizard;

public class GetBeanAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public GetBeanAction() {
	}

	@Override
	public void run(IAction action) {
		
		ExportNewWizard enw = new ExportNewWizard();
		enw.init(PlatformUI.getWorkbench(), null);
		WizardDialog wd = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), enw);
		wd.open();
		
	}
	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

}
