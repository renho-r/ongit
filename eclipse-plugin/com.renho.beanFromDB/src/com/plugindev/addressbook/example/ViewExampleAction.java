package com.plugindev.addressbook.example;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.Activator;

public class ViewExampleAction implements IViewActionDelegate {
	private IWorkbenchPart targetPart;

	public void init(IViewPart view) {
		// TODO 自动生成方法存根
		this.targetPart = view;
	}

	public void run(IAction action) {
		System.out.println(Activator.getDefault().getStateLocation().toOSString());
		MessageDialog.openInformation(targetPart.getSite().getShell(), "消息", "视图示例操作被选中");
	}

	public void selectionChanged(IAction action, ISelection selection) {
		// TODO 自动生成方法存根

	}

}
