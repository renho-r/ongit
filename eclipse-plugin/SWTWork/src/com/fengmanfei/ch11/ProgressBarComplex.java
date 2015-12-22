package com.fengmanfei.ch11;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ProgressBarComplex {
	// ��ʾ�̵߳�״̬
	static boolean bCancel = false;
	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("ProgressBar");
		shell.setLayout(new GridLayout(2, false));
		// ��ʼ��ȡ����ť
		final Button start = new Button(shell, SWT.NONE);
		start.setText("��ʼ");
		Button cancel = new Button(shell, SWT.NONE);
		cancel.setText("ȡ��");
		// ����������ʵ��
		final ProgressBar progressBar = new ProgressBar(shell, SWT.HORIZONTAL);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.grabExcessHorizontalSpace = true;
		progressBar.setLayoutData(data);
		progressBar.setMaximum(100);// �������ֵ
		progressBar.setMinimum(0);// ������Сֵ
		final int maximum = progressBar.getMaximum();// ��ȡ���ֵ
		final int minimus = progressBar.getMinimum();// ��ȡ��Сֵ
		// Ϊ��ʼ��ťע���¼�
		start.addSelectionListener(new SelectionAdapter() {
			// ��������ʼ��ťʱ
			public void widgetSelected(SelectionEvent e) {
				// �������ÿ�ʼ��ť������״̬
				start.setEnabled(false);
				// �������½��������߳�
				Runnable runnable = new Runnable() {
					public void run() {
						for (int i = minimus; i < maximum; i++) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
							}
							// ע���ڸ��½�����ʱ�������ж��߳�״̬������
							shell.getDisplay().asyncExec(new Runnable() {
								public void run() {
									if (progressBar.isDisposed())
										return;
									// �����ʱȡ�����̣߳�������������Ϊ��ʼ״̬
									if (bCancel) {
										progressBar.setSelection(0);
									}
									progressBar.setSelection(progressBar.getSelection() + 1);
								}
							});
							// �����ʱȡ�����̣߳�������ѭ��������߳�Ҳ�ͽ�����
							// �������߳�״̬
							if (bCancel) {
								bCancel = false;
								break;
							}
						}
					}
				};
				// ��������߳�
				new Thread(runnable).start();
			}
		});
		// ע��ȡ����ť�¼�
		cancel.addSelectionListener(new SelectionAdapter() {
			// ������ȡ����ťʱ
			public void widgetSelected(SelectionEvent e) {
				// �����ʱ�߳���ִ�У���ȡ���̲߳�����ʼ��ť��Ϊ����
				if (!bCancel) {
					bCancel = true;
					start.setEnabled(true);
				}
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
