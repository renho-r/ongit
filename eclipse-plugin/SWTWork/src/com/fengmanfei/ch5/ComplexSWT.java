package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class ComplexSWT {
	public static void main(String[] args) {
		Display display = new Display();
		// ��ø�Display��һ��Shell���ʵ��
		Shell shell = new Shell(display);
		// Ϊ�������ô�С
		shell.setSize(200, 200);
		// Ϊ�������ñ���������
		shell.setText("Shell");
		// Ϊ�������ò�������
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		// �ڵ�ǰ�����д�������
		Group group = new Group(shell, SWT.SHADOW_ETCHED_OUT);
		// Ϊ�������ñ���������
		group.setText("����һ����");
		// Ϊ�������ò�������
		group.setLayout(new FillLayout(SWT.VERTICAL));
		// �ڵ�ǰ�����д�����ѡť1
		Button radio1 = new Button(group, SWT.RADIO);
		// Ϊ��ѡť1���˵������
		radio1.setText("��һ����ѡť");
		// �ڵ�ǰ�����д�����ѡť2
		Button radio2 = new Button(group, SWT.RADIO);
		// Ϊ��ѡť2���˵������
		radio2.setText("�ڶ�����ѡť");
		// �ڵ�ǰ�����д�����ͨ��ť
		Button button = new Button(shell, SWT.PUSH);
		// Ϊ��ͨ��ť���˵������
		button.setText("��ť");
		// ʹ����Ĳ�����Ч
		group.layout();
		// ʹ���ڵĲ�����Ч
		shell.layout();
		// �򿪴��ڣ����ҽ�������ʾ����Ļ��
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		// ����Displayʵ�����ͷŴ���displayʱ����ȡ���ڴ���Դ���Ͽ��뱾�ز���ϵͳ������
		display.dispose();

	}
}
