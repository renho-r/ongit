package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;

public class SpinnerSample {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setLayout( new GridLayout());
		shell.setText("Spinner");
		//����΢����ť����
		final Spinner spinner = new Spinner (shell, SWT.NONE);
		spinner.setMaximum(100);//�������ֵΪ100
		spinner.setMinimum(0);//������СֵΪ0
		spinner.setIncrement(1);//����ÿ�ε�����ͷʱ������ֵ
		spinner.setPageIncrement(20);
		spinner.setSelection(50);//���õ�ǰѡ��ֵ
		spinner.setDigits(2);//����С������λ
		shell.pack();
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch ())
				display.sleep ();
		}
		display.dispose ();

	}

}
