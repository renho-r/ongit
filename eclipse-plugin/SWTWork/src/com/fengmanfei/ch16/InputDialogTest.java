package com.fengmanfei.ch16;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class InputDialogTest extends ApplicationWindow{

	public InputDialogTest() {
		super(null);
	}
	protected void configureShell(Shell shell) {
		super.configureShell( shell );
		shell.setText("����Ի���ʾ��");
	}
	
	protected Control createContents(Composite parent) {
		Composite composite = new Composite( parent , SWT.NONE);
		composite.setLayout( new GridLayout());
		Button button = new Button( composite ,SWT.NONE);
		button.setText("������Ի���");
		button.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				InputDialog inputDialog = new InputDialog(Display.getCurrent().getActiveShell(),
						"��������ʼ�",//�Ի���ı���
						"����������ʼ���ַ��",//�Ի������ʾ��Ϣ
						"ABC@hotmail.com",//�������Ĭ��ֵ
						new EmailValidator()//��֤�����ַ�����Ч��
						);
				int r = inputDialog.open();//�򿪴���
				if (r==Window.OK)//���������Ч������������ֵ
					System.out.println(inputDialog.getValue());
				else
					System.out.println("ȡ��");
			}
		});
		return parent;
	}
	public static void main(String[] args) {
		InputDialogTest test = new InputDialogTest();
		test.setBlockOnOpen( true );
		test.open();
		Display.getCurrent().dispose();
	}

}
