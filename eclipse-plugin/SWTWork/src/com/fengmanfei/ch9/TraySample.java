package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;

import com.fengmanfei.util.ImageFactory;

public class TraySample {

	public static void main(String[] args) {
		Display display = new Display();
		final Shell shell = new Shell(display);
		// ����ϵͳ����
		final Tray tray = display.getSystemTray();
		// ���ϵͳ��֧�����̲���
		if (tray == null) {
			System.out.println("��ϵͳ��֧��ϵͳ����");
			return;
		}
		final Menu trayMenu = createTrayMenu(display, shell);
		// ����ϵͳ���̵Ĺ�����
		final TrayItem item = new TrayItem(tray, SWT.NONE);
		item.setToolTipText("����һ��TrayItem");
		//������ʾϵͳ�������ͼ�꣬��ʾ����������½�
		item.setImage(ImageFactory.loadImage(display, ImageFactory.SAMPLES));
		//���д����¼�
		Listener listner = new Listener(){

			public void handleEvent(Event event) {
			    
				if ( event.type==SWT.Show )//����ʾϵͳ����ʱ
					System.out.println("��ʾ");
				else if ( event.type==SWT.Hide )//������ϵͳ����ʱ
					System.out.println("����");
				else if  ( event.type==SWT.Selection )//������ϵͳ����ʱ
					System.out.println("ѡ��");
				else if ( event.type==SWT.DefaultSelection )//��˫��ϵͳ����ʱ
					System.out.println("Ĭ��ѡ��");
				else if ( event.type==SWT.MenuDetect )//���һ�ϵͳ����ʱ
					trayMenu.setVisible(true);//���ò˵�Ϊ��ʾ״̬
			}
			
		};
		//Ϊ��ϵͳ������ע���¼�
		item.addListener( SWT.Show, listner );
		item.addListener( SWT.Hide , listner );
		item.addListener( SWT.Selection , listner );
		item.addListener( SWT.DefaultSelection , listner );
		item.addListener( SWT.MenuDetect , listner );
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		ImageFactory.dispose();
		display.dispose();

	}

	private static Menu createTrayMenu(Display display, final Shell shell) {
		// ����һ������ʽ�˵���ʹ�ó���SWT.POP_UP
		final Menu trayMenu = new Menu(shell, SWT.POP_UP);
		// ����˵��еĲ˵���
		MenuItem welcomeItem = new MenuItem(trayMenu, SWT.PUSH);
		welcomeItem.setText("��ӭ");
		welcomeItem.setImage(ImageFactory.loadImage(display,
				ImageFactory.ECLIPSE));

		new MenuItem(trayMenu, SWT.SEPARATOR);

		MenuItem updatetem = new MenuItem(trayMenu, SWT.PUSH);
		updatetem.setText("���߸���");

		MenuItem aboutItem = new MenuItem(trayMenu, SWT.PUSH);
		aboutItem.setText("��������");
		aboutItem.setImage(ImageFactory.loadImage(display, ImageFactory.SAMPLES));

		trayMenu.setDefaultItem(welcomeItem);
		return trayMenu;
	}

}
