package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.util.ImageFactory;

public class ToolBarSample1 {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText("ToolBar");
		shell.setLayout( new GridLayout());
		Composite tool = new Composite( shell ,SWT.NONE);
		tool.setLayoutData(new GridData(SWT.LEFT,SWT.TOP,true ,false));
		//��������������ʹ��SWT.NONE��ʽ
		final ToolBar toolBar = new ToolBar (tool, SWT.FLAT);
		
		//�������湤�߰�ť
		ToolItem saveItem = new ToolItem ( toolBar , SWT.PUSH);
		//���ù��߰�ť��ͼƬ
		saveItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAVE_EDIT));
		saveItem.setHotImage(ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT) );
		//���ù��߰�ť�ϵ�����
		saveItem.setText("����");
		//���ù��߰�ť�ϵ���ʾ��Ϣ
		saveItem.setToolTipText("����");
		//������ӡ���߰�ť
		
		ToolItem printItem = new ToolItem ( toolBar , SWT.PUSH);
		printItem.setImage( ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT));
		printItem.setText("��ӡ");
		printItem.setToolTipText("��ӡ");
		
		new ToolItem ( toolBar , SWT.SEPARATOR);
		//�����������߰�ť������Ϊ����ʽ��ʹ��SWT.DROP_DOWN��ʽ
		final ToolItem helpItem = new ToolItem ( toolBar , SWT.DROP_DOWN);
		helpItem.setImage( ImageFactory.loadImage( display , ImageFactory.HELP_CONTENTS));
		helpItem.setText("����");
		helpItem.setToolTipText("����");
		
		//����һ������ʽ�˵���ʹ�ó���SWT.POP_UP
		final Menu helpMenu = new Menu( shell , SWT.POP_UP);
		//����˵��еĲ˵���
		MenuItem welcomeItem = new MenuItem(helpMenu,SWT.PUSH);
		welcomeItem.setText("��ӭ");
		welcomeItem.setImage( ImageFactory.loadImage( display , ImageFactory.ECLIPSE) );
		
		new MenuItem( helpMenu ,SWT.SEPARATOR);
		
		MenuItem updatetem = new MenuItem(helpMenu,SWT.PUSH);
		updatetem.setText("���߸���");
		
		MenuItem aboutItem = new MenuItem(helpMenu,SWT.PUSH);
		aboutItem.setText("��������");
		aboutItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAMPLES) );
		//Ϊ����������ע�ᵥ��������ͷ�¼�
		helpItem.addListener(SWT.Selection,new Listener(){

			public void handleEvent(Event event) {
				//����������¼�Ϊ������ť
				if (event.detail==SWT.ARROW)
				{
					//��ð�����ť��������λ�úʹ�С������ڸ�����
					Rectangle rect = helpItem.getBounds ();
					Point pt = new Point (rect.x, rect.y + rect.height);//����˵����ֵ���ʼλ��
					pt = toolBar.toDisplay (pt);//���õ�ת��Ϊ����Ļ�����λ��
					helpMenu.setLocation (pt.x, pt.y);//���ò˵���ʾ��λ��
					helpMenu.setVisible (true);//��ʾ�˵�
				}
				
			}
			
		});
		
		toolBar.pack ();
		Text content = new Text (shell,SWT.MULTI);
		content.setLayoutData( new GridData(SWT.FILL,SWT.FILL,true,true));
		
		shell.setSize( new Point ( 200,150 ));
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		//�ͷ�ͼƬ��Դ
		ImageFactory.dispose();
		display.dispose ();

	}

}
