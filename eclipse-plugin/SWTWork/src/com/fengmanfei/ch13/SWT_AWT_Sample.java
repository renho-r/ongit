package com.fengmanfei.ch13;
import java.awt.Label;
import java.awt.TextField;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class SWT_AWT_Sample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT and Swing/AWT Example");
		shell.setLayout( new FillLayout());
		//����һ������࣬��ʽ����ΪSWT.EMBEDDED
		Composite composite = new Composite(shell, SWT.EMBEDDED);
		//����������ת����AWT�е�Frame����
		java.awt.Frame awtFrame = SWT_AWT.new_Frame(composite);
		awtFrame.setSize(200,150);
		awtFrame.setVisible( true );
		//���һ��AWT��ǩ
		java.awt.Label label = new Label();
		label.setText("����һ��AWT��ǩ");
		awtFrame.add( label ,java.awt.BorderLayout.NORTH);
		////���һ��AWT�ı���
		TextField textField  = new TextField();
		textField.setText("����һ��AWT�ı���");
		awtFrame.add( textField ,java.awt.BorderLayout.CENTER);
		shell.pack();
		shell.open();
		while(!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
