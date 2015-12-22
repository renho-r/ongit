package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class LinkSample {

	public static void main(String[] args) {
		final Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		shell.setText("LinkSample");
		//���������ı�����
		Link link = new Link(shell, SWT.NONE);
		//���������ı��е��ַ�������ҳ�еĳ��������ı��������
		//<a href="���ӵ�ַ">�����ı�</a>
		//����\n���Ա�ʾΪ���з�
		String text = "����һ��û�����ӵ�ַ�������ı�:<A>�����</A>.\n\n����һ�������ӵ�ַ�������ı�,���ӵ�ַ��www.sina.com.cn:<A href=\"www.sina.com.cn\">�����</A>";
		link.setText(text);
		link.setSize(400, 400);
		//ע�����ı�ʱ�¼�
		link.addListener (SWT.Selection, new Listener () {
			public void handleEvent(Event event) {
				//��ʾ����ӡ���ı�
				System.out.println("���������: " + event.text);
			}
		});
		shell.pack();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

	}

}
