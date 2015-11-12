package com.renho.beanfromdb.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.dialogs.DbConfigDialog;

public class ViewCreateDbAction implements IViewActionDelegate {
	
	private IWorkbenchPart targetPart;
	
	public void init(IViewPart view) {
		this.targetPart = view;
	}

	public void run(IAction action) {
		
		/*Display display = Display.getDefault();
		Shell createDbShell = new Shell(display, SWT.CLOSE | SWT.APPLICATION_MODAL);
		createDbShell.setText("≈‰÷√ ˝æ›ø‚");
		createDbShell.setSize(200, 300);
		createDbShell.open();
		
		System.out.println(Activator.getDefault().getStateLocation().toOSString());*/
				
		DbConfigDialog dbConfigDialog = new DbConfigDialog(targetPart.getSite().getShell());
		dbConfigDialog.open();
		
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

}
