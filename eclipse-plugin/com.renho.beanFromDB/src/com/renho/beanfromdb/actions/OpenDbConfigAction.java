package com.renho.beanfromdb.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class OpenDbConfigAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public OpenDbConfigAction() {
		System.out.println(111111111);
	}

	@Override
	public void run(IAction action) {
		MessageDialog.openInformation(targetPart.getSite().getShell(), "消息", "对象示例操作被选中");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println(333);
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}
}
