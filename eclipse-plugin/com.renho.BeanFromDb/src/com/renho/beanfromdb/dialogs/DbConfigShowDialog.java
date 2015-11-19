package com.renho.beanfromdb.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DbConfigShowDialog extends Dialog {
	private Text showText;
	private String classInfo;
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
        container.setLayout(gridLayout);
        showText = new Text(container, SWT.BORDER|SWT.WRAP|SWT.MULTI|SWT.V_SCROLL);
        showText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
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
}
