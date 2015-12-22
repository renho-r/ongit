package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Text����ʾ��");

		final Text content = new Text(shell, SWT.WRAP | SWT.V_SCROLL);
		content.setBounds(5, 5, 325, 200);

		Button selectAll = new Button(shell, SWT.NONE);
		selectAll.setText("ȫѡ");
		selectAll.setBounds(5, 225, 75, 25);
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ѡ�������ı�
				content.selectAll();
			}

		});

		Button cancel = new Button(shell, SWT.NONE);
		cancel.setText("ȡ��ȫѡ");
		cancel.setBounds(90, 225, 75, 25);
		cancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// �����ѡ�е��ı�
				if (content.getSelectionCount() > 0)
					content.clearSelection();// ���ѡ��
			}

		});

		Button copy = new Button(shell, SWT.NONE);
		copy.setText("����");
		copy.setBounds(175, 225, 75, 25);
		copy.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// ���Ƶ����а�
				content.copy();
			}

		});

		Button paste = new Button(shell, SWT.NONE);
		paste.setText("ճ��");
		paste.setBounds(260, 225, 75, 25);
		paste.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				// �����а������ճ��
				content.paste();
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

	public static Label createLabel(Composite parent, String text) {
		Label l = new Label(parent, SWT.RIGHT);
		l.setText(text);
		return l;
	}

}
