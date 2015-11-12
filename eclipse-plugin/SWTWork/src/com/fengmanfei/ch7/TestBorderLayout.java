package com.fengmanfei.ch7;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TestBorderLayout {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(200, 150);
		shell.setLayout(new BorderLayout());

		Button buttonWest = new Button(shell, SWT.PUSH);
		buttonWest.setText("��");
		buttonWest.setLayoutData(new BorderData(SWT.LEFT));

		Button buttonEast = new Button(shell, SWT.PUSH);
		buttonEast.setText("��");
		buttonEast.setLayoutData(new BorderData(SWT.RIGHT));

		Button buttonNorth = new Button(shell, SWT.PUSH);
		buttonNorth.setText("��");
		buttonNorth.setLayoutData(new BorderData(SWT.TOP));

		Button buttonSouth = new Button(shell, SWT.PUSH);
		buttonSouth.setText("��");
		buttonSouth.setLayoutData(new BorderData(SWT.BOTTOM));

		Text text = new Text(shell, SWT.MULTI);
		text.setText("�м�");
		text.setLayoutData(new BorderData());

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();

	}
}
