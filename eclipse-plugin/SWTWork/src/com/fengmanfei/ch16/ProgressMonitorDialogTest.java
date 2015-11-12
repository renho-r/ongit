package com.fengmanfei.ch16;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class ProgressMonitorDialogTest extends ApplicationWindow {

	public ProgressMonitorDialogTest() {
		super(null);
	}

	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.VERTICAL));
		Button bt1 = new Button(composite, SWT.NONE);
		bt1.setText("�򿪽������Ի���");
		bt1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				showDialog();
			}
		});
		return parent;
	}

	private void showDialog() {
		try {
			ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			// ������̨�̶߳���
			IRunnableWithProgress runnalble = new IRunnableWithProgress() {
				// �߳����еĴ��벿��
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					// ������ʾ��UI�����ϵ��߳���Ϣ
					monitor.beginTask("��ʼִ������...", 100);
					// ���߳����û�û��ȡ�������������ѭ��10��
					// ����ÿ��ѭ�������ý�������10,��ʾһ�����������
					for (int i = 0; i < 10 && !monitor.isCanceled(); i++) {
						Thread.sleep(500);// Ϊ��ģ���ʱ�Ĳ�����ÿ��ѭ�����ø��߳���Ϣ������
						monitor.worked(10);// ��������10
						monitor.subTask("����ɵ�" + i + "������");// ��ʾ����״̬
					}
					// ѭ����ɺ����ô����������
					monitor.done();
					// �����ʱΪ�û�ȡ���Ĳ���
					if (monitor.isCanceled())
						throw new InterruptedException("�û���ȡ���˲���");
				}
			};
			progressDialog.run(true, false, runnalble);// �����߳�
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ProgressMonitorDialogTest test = new ProgressMonitorDialogTest();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();
	}
}
