package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class MenuSample {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Menu Sample");
		// �������˵������ڷ��õ��˵�����
		Menu main = new Menu(shell, SWT.BAR);

		// ���˵��ĵ�һ���˵���
		MenuItem file = new MenuItem(main, SWT.CASCADE);
		file.setText("�ļ�(&F)");

		// �ļ��˵���Ϊ����ʽ
		//Menu filemenu = new Menu(shell, SWT.DROP_DOWN);
		Menu filemenu = new Menu(file);
		// �½��˵���
		MenuItem newItem = new MenuItem(filemenu, SWT.PUSH);
		newItem.setText("�½�(&N)  ALT+SHIFT+N");
		// ���ÿ�ݼ�
		newItem.setAccelerator(SWT.ALT + SWT.SHIFT + 'N');
		// �򿪲˵���
		MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
		openItem.setText("��(&O)");
		// �ָ��߲˵���
		new MenuItem(filemenu, SWT.SEPARATOR);
		// �˳��˵���
		MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
		exitItem.setText("�˳�(&E)");
		exitItem.setAccelerator(SWT.ALT + SWT.SHIFT + 'E');
		// Ϊ�˳��˵���ע���¼�
		exitItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				// �������˳��˵�ʱ���ͷŴ���
				shell.dispose();
			}
		});
		// ���ļ��˵����õ����˵��ĵ�һ���˵�����
		file.setMenu(filemenu);

		// ���˵��ĵڶ����˵���
		MenuItem view = new MenuItem(main, SWT.CASCADE);
		view.setText("��ͼ(&V)");

		Menu viewMenu = new Menu(shell, SWT.DROP_DOWN);
		MenuItem normalItem = new MenuItem(viewMenu, SWT.RADIO);
		normalItem.setText("��ͨ(&N)");
		
		//
		MenuItem test = new MenuItem(viewMenu, SWT.CASCADE);
		Menu t1 = new Menu( test );
		MenuItem i1 = new MenuItem(t1, SWT.PUSH);
		i1.setText("heh");
		test.setMenu( t1 );
		normalItem.setText("��ͨ(&N)");
		//
		// ���ļ��˵����õ����˵��ĵ�һ���˵�����
		view.setMenu(viewMenu);
		// �����˵����õ�������
		shell.setMenuBar(main);
		//shell.setMenu( main );
		
		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
