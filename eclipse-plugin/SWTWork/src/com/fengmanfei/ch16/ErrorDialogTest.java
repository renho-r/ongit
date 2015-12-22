package com.fengmanfei.ch16;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class ErrorDialogTest extends ApplicationWindow{
	final String dummyPlugin = "plugin id";
	public ErrorDialogTest() {
		super(null);
	}
	protected Control createContents(Composite parent) {
		Composite composite = new Composite ( parent , SWT.NONE);
		composite.setLayout( new RowLayout(SWT.VERTICAL));
		Button bt1 = new Button(composite ,SWT.NONE);
		bt1.setText("��һ������Ի���");
		bt1.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//����һ��Status����
				Status status = new Status(IStatus.ERROR, dummyPlugin, 1, "δ�ҵ�����", new ClassNotFoundException());
				//����������ʾ�Ի���
				ErrorDialog dlg = new ErrorDialog(Display.getCurrent().getActiveShell(),
						"��ʾ����", //�Ի���ı���
						"װ����ʱ���ִ���",//�Ի����������Ϣ 
						status, //Status����
						IStatus.ERROR);//ֻ��ʾ����ΪIStatus.ERROR�Ĵ���
				dlg.open();
			}		
		});
		Button bt2 = new Button(composite ,SWT.NONE);
		bt2.setText("��һ������ʾ�����Ի���");
		bt2.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				IStatus[] statuses = new IStatus[4];
				statuses[0] = new Status(IStatus.INFO, dummyPlugin, IStatus.OK, "δ�ҵ������", new ClassNotFoundException());
				statuses[1] = new Status(IStatus.ERROR, dummyPlugin, IStatus.OK, "δ�ҵ��ļ�����", new FileNotFoundException());
				statuses[2] = new Status(IStatus.WARNING, dummyPlugin, IStatus.OK, "���д���", new RuntimeException());
				statuses[3] = new Status(IStatus.WARNING, dummyPlugin, IStatus.OK, "���ݿ��ѯ����", new SQLException());
				MultiStatus multiStatus = new MultiStatus(dummyPlugin, IStatus.OK, statuses, "�����ڼ���� ", new Exception());
				ErrorDialog dlg = new ErrorDialog(Display.getCurrent().getActiveShell(),
						"��ʾ����", //�Ի���ı���
						"����JFace�ڼ䷢���Ĵ���",//�Ի����������Ϣ 
						multiStatus, //Status����
						IStatus.WARNING|IStatus.ERROR);//��ʾ����ΪIStatus.WARNING��IStatus.ERROR�Ĵ���
				dlg.open();
			}		
		});
		return parent;
	}

	public static void main(String[] args) {
		ErrorDialogTest test = new ErrorDialogTest();
		test.setBlockOnOpen( true );
		test.open();
		Display.getCurrent().dispose();
	}
}
