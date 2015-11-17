package com.renho.beanfromdb.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.modal.DBConfig;

public class DbConfigShowDialog extends Dialog {
	private Text showText;
	private String classInfo;
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
        container.setLayout(gridLayout);
        
        showText = new Text(container, SWT.BORDER|SWT.MULTI);
        //showText.setBounds(10, 20, 300, 30);
        showText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
        showText.setText(classInfo);
        
        return container;
	}

	public DbConfigShowDialog(Shell shell, String classInfo) {
		super(shell);
		this.classInfo = classInfo;
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(400,400);
	}
	
	@Override
	protected void configureShell(Shell newShell){
		super.configureShell(newShell);
		newShell.setText("Class");
	}
	
//	@Override
//	protected void initializeBounds() {
//		super.createButton((Composite) this.getButtonBar(), IDialogConstants.OK_ID, "copy", false);
//		super.createButton((Composite) this.getButtonBar(), IDialogConstants.CANCEL_ID, "È¡Ïû", false);
//		super.initializeBounds();
//	}
	
//	@Override
//	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
//		return null;
//	}
	
//	@Override
//	protected void buttonPressed(int buttonId) {
//		DBConfig dbConfig = null;
//		if(IDialogConstants.OK_ID == buttonId) {
//			Clipboard clipboard = new Clipboard(PlatformUI.getWorkbench().getDisplay());
//			clipboard.dispose();
//		}
//	}
}
