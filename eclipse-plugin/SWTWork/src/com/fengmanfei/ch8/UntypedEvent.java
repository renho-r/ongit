package com.fengmanfei.ch8;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class UntypedEvent {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("�����͵��¼�");
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(5, 5, 50, 25);
		button.setText("�ƶ���");
		Listener listener = new Listener() {
			public void handleEvent(Event e) {
				if (e.type == SWT.KeyDown) {
					Control control = (Control) e.widget;
					// ��øÿؼ���λ�úʹ�С
					Rectangle current = control.getBounds();
					if (e.keyCode == SWT.ARROW_DOWN)// ��������ˡ��¡�����
						current.y++;// ����һ������
					else if (e.keyCode == SWT.ARROW_UP)// ��������ˡ��ϡ�����
						current.y--;// ����һ������
					else if (e.keyCode == SWT.ARROW_LEFT)// ��������ˡ��󡱰���
						current.x--;// ����һ������
					else if (e.keyCode == SWT.ARROW_RIGHT)// ��������ˡ��ҡ�����
						current.x++;// ����һ������
					// �������ÿؼ���λ��
					control.setBounds(current);
				}else if ( e.type == SWT.Selection){
					System.out.println("�㵥���˴˰�ť");
				}
			}

		};
		// ע�������͵��¼�������
		button.addListener(SWT.KeyDown, listener);
		button.addListener(SWT.Selection, listener);
		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
