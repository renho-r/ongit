package com.renho.mytest.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class TestObjectAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public TestObjectAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		MessageDialog.openInformation(targetPart.getSite().getShell(), "open", "open message");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

}
