package com.fengmanfei.myrcp.forms;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

public class NonEclipse {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT��ʾ��");
		shell.setLayout( new FillLayout());
		//���������߶���
		FormToolkit toolkit = new FormToolkit(shell.getDisplay());
		//ͨ�������߶��󴴽��ɹ����ı�����
		ScrolledForm form = toolkit.createScrolledForm(shell);
		form.setLayout( new GridLayout());
		//���ñ��ı�
		form.setText("Hello, Non Eclipse ��");
		toolkit.createLabel(form,"text");
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		toolkit.dispose();
		display.dispose();
	}
}
