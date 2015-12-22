package com.renho.mytest.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;

public class TestViewAction implements IViewActionDelegate {
	private IWorkbenchPart targetPart;
	public TestViewAction() {
		super();
	}

	@Override
	public void run(IAction action) {
		System.out.println(1111111);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		
	}

	@Override
	public void init(IViewPart view) {
		this.targetPart = view;
	}

}
