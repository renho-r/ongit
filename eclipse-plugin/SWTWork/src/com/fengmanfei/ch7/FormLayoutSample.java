package com.fengmanfei.ch7;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FormLayoutSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display, SWT.SHELL_TRIM);

		// ����FormLayout����
		FormLayout formLayout = new FormLayout();
		formLayout.marginHeight = 5;// �������²���Ϊ5������
		formLayout.marginWidth = 5;// �������Ҳ���Ϊ5������
		shell.setLayout(formLayout);

		Button bt1 = new Button(shell, SWT.PUSH);
		bt1.setText("B1");
		// ����FormData����
		FormData formData = new FormData();
		// �趨�ؼ����ϱ߿��λ��
		formData.top = new FormAttachment(30, 70, 60);
		// �趨�ؼ����±߿��λ��
		formData.bottom = new FormAttachment(100, -5);
		bt1.setLayoutData(formData);

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
