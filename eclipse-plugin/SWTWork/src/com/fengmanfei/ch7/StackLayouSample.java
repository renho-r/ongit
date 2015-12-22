package com.fengmanfei.ch7;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class StackLayouSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		// ���������ı�������
		final Composite parent = new Composite(shell, SWT.NONE);
		// �������Ĳ�������
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		// ������ջʽ����
		final StackLayout layout = new StackLayout();
		// ����קʽ����Ӧ�������
		parent.setLayout(layout);
		// ����10���ı���
		final Text[] textArray = new Text[10];
		for (int i = 0; i < 10; i++) {
			textArray[i] = new Text(parent, SWT.MULTI);
			textArray[i].setText("���ǵ�" + i + "���ı���");
		}
		// ���ö�ջ�е�ǰ��ʾ�Ŀؼ�
		layout.topControl = textArray[0];

		Button b = new Button(shell, SWT.PUSH);
		b.setText("��ʾ��һ���ı���");
		// ���浱ǰ��ʾ���ı��������ֵ
		final int[] index = new int[1];
		// Ϊ��ť��ӵ���¼�
		b.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				// �������һ���ı����������
				index[0] = (index[0] + 1) % 10;
				// ���õ�ǰ��ʾ�Ŀؼ�
				layout.topControl = textArray[index[0]];
				// ����ˢ�²���
				parent.layout();
			}
		});

		shell.setSize(200, 150);
		shell.open();
		while (shell != null && !shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

	}

}
