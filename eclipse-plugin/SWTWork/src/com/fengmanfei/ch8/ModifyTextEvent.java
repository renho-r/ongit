package com.fengmanfei.ch8;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class ModifyTextEvent implements VerifyListener {

	private Shell shell;

	private Text top;

	private Text bottom;

	public ModifyTextEvent() {
		shell = new Shell();
		shell.setText("�ı��ı��¼�ʾ��");
		shell.setLayout(new GridLayout(2, false));
		new Label(shell, SWT.NONE).setText("������Сд��ĸ��");
		top = new Text(shell, SWT.SINGLE);
		top.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		top.addVerifyListener(this);
		new Label(shell, SWT.NONE).setText("��Ӧ�Ĵ�д��ĸ��");
		bottom = new Text(shell, SWT.SINGLE);
		bottom.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		bottom.setEditable(false);
		shell.setSize(300, 100);
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	// VerifyListener�ӿ��еķ���
	public void verifyText(VerifyEvent e) {

		char c = e.character;// ���������ַ�
		// ������ַ���Ϊ��ĸ���߲��Ǵ�д��ĸ��ȡ������
		if (!Character.isLetter(c) || Character.isUpperCase(c)) {
			e.doit = false;
			return;
		}
		// ���±ߵ��ı������������Ӧ�Ĵ�д��ĸ
		bottom.append("" + Character.toUpperCase(c));
	}

	public static void main(String[] args) {
		Display display = Display.getDefault();
		ModifyTextEvent sample = new ModifyTextEvent();
		sample.getShell().open();
		while (!sample.getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
