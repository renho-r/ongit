package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ScrolledCompositeSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("ScrolledComposite");

		// ����һ������������
		final ScrolledComposite sc = new ScrolledComposite(shell, SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.BORDER);
		// ����һ����ͨ�����
		final Composite c = new Composite(sc, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		c.setLayout(layout);
		for (int i = 0; i < 20; i++) {
			Button bt = new Button(c, SWT.PUSH);
			bt.setText("��ť" + i);
			c.setSize(c.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		}
		// ����ͨ�������Ϊ�ܿصĹ������
		sc.setContent(c);
		// sc.setAlwaysShowScrollBars( true );
		// sc.setExpandHorizontal( true );
		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
