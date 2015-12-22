package com.fengmanfei.ch8;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class MouseEventSample {
	private Shell shell;
	private Button button;
	private MoveButtonListener listener;
	public MouseEventSample() {
		shell = new Shell();
		shell.setText("����¼�");
		button = new Button(shell, SWT.NONE);
		button.setBounds(5, 5, 50, 25);
		button.setText("��ť");
		listener = new MoveButtonListener();//��������������
		button.addMouseListener(listener);//ע����������
		button.addMouseTrackListener(listener);//ע�������ټ�����
		shell.setSize(200, 150);
		
	}

	//�������࣬ʵ�������������Ľӿ�
	public class MoveButtonListener implements MouseMoveListener, MouseListener ,MouseTrackListener{
		//������ƶ�ʱ
		public void mouseMove(MouseEvent e) {
			//���ȵ�ǰ����λ��ת��Ϊ���ڵ�����λ��
			Point convertPoint = Display.getCurrent().map(button, shell , e.x,e.y );
			Rectangle current = button.getBounds();
			//�������ð�ť��λ�ã�ʹ֮��������ƶ�
			button.setBounds(convertPoint.x, convertPoint.y, current.width, current.height);
		}
		//���˫���¼�
		public void mouseDoubleClick(MouseEvent e) {
			System.out.println(e.toString());
			System.out.println("˫���˸ð�ť");
		}
		//����갴��ʱ��Ϊ��ťע������ƶ�������
		public void mouseDown(MouseEvent e) {
			System.out.println(e.toString());
			button.addMouseMoveListener(listener);

		}
		//�����̧��ʱ��ֹͣ�Ϸţ��Ƴ�����ƶ�������
		public void mouseUp(MouseEvent e) {
			button.removeMouseMoveListener(listener);
		}
		//�������뵽��ť����ʱ
		public void mouseEnter(MouseEvent e) {
			System.out.println(e.toString());
			System.out.println("�����뵽��ť����");
		}
		//������뿪����ť����ʱ
		public void mouseExit(MouseEvent e) {
			System.out.println("����뿪��ť����");
		}
		//������ڰ�ť����ʱ
		public void mouseHover(MouseEvent e) {
			System.out.println("����ڰ�ť����");
		}
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public static void main(String[] args) {
		Display display =Display.getDefault();
		MouseEventSample sample = new MouseEventSample();
		sample.getShell().open();
		while (!sample.getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
