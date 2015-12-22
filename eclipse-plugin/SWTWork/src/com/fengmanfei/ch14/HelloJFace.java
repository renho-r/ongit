package com.fengmanfei.ch14;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class HelloJFace extends ApplicationWindow {

	public HelloJFace() {
		super(null);
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)
	 * �÷������𴴽������еĿؼ�
	 */
	protected Control createContents(Composite parent) {
		//getShell()����Ϊ�����еķ��������ش��ڵ�Shell����
		//���ô�����ʾ�ı���
		getShell().setText("JFace");
		//������һ����ť
		Button button = new Button(parent, SWT.CENTER);
		button.setText("��ӭ���뵽JFace������!");
		//�������ڲ���
		parent.pack();
		return parent;
	}
	
	public static void main(String[] args) {
		//�������ڶ���
		HelloJFace helloJFace = new HelloJFace();
		//���ô��ڴ��ڴ�״̬
		helloJFace.setBlockOnOpen( true );
		//�򿪴���
		helloJFace.open();
		//�ͷ�Dipsplay����
		Display.getCurrent().dispose();
	}
}
