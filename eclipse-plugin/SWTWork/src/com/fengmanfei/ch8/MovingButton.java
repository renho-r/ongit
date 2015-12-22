package com.fengmanfei.ch8;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class MovingButton {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("���ƶ��İ�ť");
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(5, 5, 50, 25);
		button.setText("�ƶ���");
		// ע������¼�������
		button.addKeyListener(new KeyListener() {
			// ���̰��º�
			public void keyPressed(KeyEvent e) {
				/*
				 * int bits = SWT.CTRL | SWT.ALT | SWT.SHIFT; if ((e.stateMask &
				 * bits) != 0) { e.doit = false ;//ȡ�����¼� return;//������ }
				 */
				// ��ô������¼��Ŀؼ�����
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
			}

			public void keyReleased(KeyEvent e) {

			}

		});

		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
