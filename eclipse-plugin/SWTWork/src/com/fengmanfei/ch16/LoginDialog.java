package com.fengmanfei.ch16;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class LoginDialog extends Dialog {
	//���尴ť�ĳ���
	public static final int LOGIN_ID = 0;
	public static final int LOGOUT_ID = 1;
	public static final String LOGIN_LABEL = "��¼";
	public static final String LOGOUT_LABEL = "�˳�";
	//�û����������ı���
	private Text userName;
	private Text password;
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("��¼");
	}
	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * ���Ǹ÷������ڴ˷����д����Ի������������
	 */
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);
		Group group = new Group(comp, SWT.NONE);
		group.setText("��¼ϵͳ");
		GridLayout layout = new GridLayout();
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		layout.numColumns = 2;
		group.setLayout(layout);
		new Label(group, SWT.NONE).setText("�û���: ");
		userName = new Text(group, SWT.BORDER | SWT.SINGLE);
		new Label(group, SWT.NONE).setText("����: ");
		password = new Text(group, SWT.BORDER | SWT.SINGLE);
		password.setEchoChar('*');
		return parent;
	}
	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 * ���Ǹ÷������ڴ˷����д�������Ҫ�İ�ť
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		//ʹ�ø����д�����ť�ķ���������½���˳���ť
		createButton(parent, LoginDialog.LOGIN_ID, LoginDialog.LOGIN_LABEL, true);
		createButton(parent, LoginDialog.LOGOUT_ID, LoginDialog.LOGOUT_LABEL, false);
	}
	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 * �������Ի����еİ�ťʱ�����ô˷���
	 */
	protected void buttonPressed(int buttonId) {
		//�����ʱ�����˵�½��ť
		if (LoginDialog.LOGIN_ID == buttonId)
			System.out.println("��¼���û���Ϊ" + userName.getText() + ",����Ϊ" + password.getText());
		//�����ʱ������ȡ����ť�����ø����
		else if (LoginDialog.LOGOUT_ID == buttonId)
			close();
	}
}
