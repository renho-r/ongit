package com.fengmanfei.ch21.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class AboutDialog extends Dialog {

	public AboutDialog(Shell parentShell) {
		super(parentShell);
	}
	protected Control createContents(Composite parent) {
		this.getShell().setSize(200,150);
		this.getShell().setText("��������");
		parent.setLayout( new GridLayout());
		new Label(parent, SWT.CENTER).setText("JS�༭�� Verson 1.0");
		new Label(parent, SWT.CENTER).setText("���ߣ�Janet");
		new Label(parent, SWT.RIGHT).setText("2006.8");
		return parent;
	}
}
