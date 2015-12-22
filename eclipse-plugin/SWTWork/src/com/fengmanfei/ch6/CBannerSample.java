package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CBannerSample {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("CBanner");

		// ����CBanner����
		CBanner banner = new CBanner(shell, SWT.BORDER);
		banner.setLayout(new FillLayout());

		// ����������壬�ֱ���õ���࣬�Ҳ�͵ײ�
		Composite left = new Composite(banner, SWT.NONE);
		left.setLayout(new FillLayout());
		new Text(left, SWT.MULTI).setText("���");

		Composite right = new Composite(banner, SWT.NONE);
		right.setLayout(new FillLayout());
		new Text(right, SWT.MULTI).setText("�Ҳ�");

		Composite bottom = new Composite(banner, SWT.NONE);
		bottom.setLayout(new FillLayout());
		new Text(bottom, SWT.MULTI).setText("�²�");

		// �������Ŀؼ�
		banner.setLeft(left);
		// �����Ҳ�Ŀؼ�
		banner.setRight(right);
		// ���õײ��Ŀؼ�
		banner.setBottom(bottom);

		banner.setSimple(false);
		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
