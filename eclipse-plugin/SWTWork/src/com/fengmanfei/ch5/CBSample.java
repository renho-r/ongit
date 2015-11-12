package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class CBSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWTʾ��");

		// ����shell�Ĳ���
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.marginWidth = 10;
		shell.setLayout(layout);

		Group group = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		group.setLayout(new FillLayout(SWT.VERTICAL));
		group.setText("���İ����ǣ�");

		// ���尴ťΪ���飬Ҫ���¼���������ʹ�ð�ť�����ã�Ҫ���ó�final��
		final Button[] button = new Button[5];
		String[] items = { "����", "��Ӿ", "����", "˯��", "���" };
		// ��ʼ����ť����
		for (int i = 0; i < button.length; i++) {
			button[i] = new Button(group, SWT.CHECK);
			button[i].setText(items[i]);
		}
		// ȷ����ť
		Button ok = new Button(group, SWT.PUSH);
		ok.setText("ȷ��");
		// ���ȷ����ť�¼�
		ok.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				// ѭ�����а�ť
				for (int i = 0; i < button.length; i++)
					// ���ѡ�У������ѡ�е�ֵ
					if (button[i].getSelection())
						System.out.println("��ѡ���ˣ�" + button[i].getText());
			}

		});
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
