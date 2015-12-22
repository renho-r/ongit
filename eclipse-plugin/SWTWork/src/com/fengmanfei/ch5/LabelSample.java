package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("��ǩʾ��");

		RowLayout layout = new RowLayout(SWT.WRAP);
		layout.marginWidth = 10;
		shell.setLayout(layout);

		Group group1 = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		group1.setLayout(new FillLayout(SWT.VERTICAL));
		group1.setText("�ı���ǩ��");

		Label l1 = new Label(group1, SWT.LEFT);
		l1.setText("SWT.LEFT");
		Label l2 = new Label(group1, SWT.CENTER);
		l2.setText("SWT.CENTER");
		Label l3 = new Label(group1, SWT.RIGHT);
		l3.setText("SWT.RIGHT");

		Group group2 = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		group2.setLayout(new FillLayout(SWT.VERTICAL));
		group2.setText(" ˮƽ�ָ��ߣ�SWT.HORIZONTAL");

		Label ld4 = new Label(group2, SWT.NONE);
		ld4.setText("SWT.SHADOW_IN");
		Label l4 = new Label(group2, SWT.SEPARATOR | SWT.HORIZONTAL
				| SWT.SHADOW_IN);

		Label ld5 = new Label(group2, SWT.NONE);
		ld5.setText("SWT.SHADOW_OUT");
		Label l5 = new Label(group2, SWT.SEPARATOR | SWT.HORIZONTAL
				| SWT.SHADOW_OUT);

		Label ld6 = new Label(group2, SWT.NONE);
		ld6.setText("SWT.SHADOW_NONE");
		Label l6 = new Label(group2, SWT.SEPARATOR | SWT.HORIZONTAL
				| SWT.SHADOW_NONE);

		Group group3 = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		group3.setLayout(new FillLayout(SWT.HORIZONTAL));
		group3.setText("��ֱ�ָ��ߣ�SWT.VERTICAL");

		Label l7 = new Label(group3, SWT.SEPARATOR | SWT.VERTICAL
				| SWT.SHADOW_IN);
		Label l8 = new Label(group3, SWT.SEPARATOR | SWT.VERTICAL
				| SWT.SHADOW_OUT);
		Label l9 = new Label(group3, SWT.SEPARATOR | SWT.VERTICAL
				| SWT.SHADOW_NONE);

		shell.layout();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
