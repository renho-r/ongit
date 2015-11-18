package com.renho.beanfromdb.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.wizard.ExportNewWizard;

public class GetBeanAction implements IObjectActionDelegate {

	@SuppressWarnings("unused")
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
