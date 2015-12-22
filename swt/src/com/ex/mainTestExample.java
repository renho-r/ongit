package com.ex;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class mainTestExample extends AbstractExample {
	public static void main(String[] args) {
		new mainTestExample().run();
	}

	public void todo(Shell shell) {
		// ...add something you like
		Label label_1 = new Label(shell, SWT.CENTER);
		label_1.setText("this is the text of a label");
	}
}