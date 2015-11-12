package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import com.fengmanfei.util.ImageFactory;

public class ToolBarSample {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText("ToolBar");
		shell.setLayout( new GridLayout());
		Composite tool = new Composite( shell ,SWT.NONE);
		tool.setLayoutData(new GridData(SWT.LEFT,SWT.TOP,true ,false));
		//��������������ʹ��SWT.NONE��ʽ
		ToolBar toolBar = new ToolBar (tool, SWT.FLAT);
		
		//�������湤�߰�ť
		ToolItem saveItem = new ToolItem ( toolBar , SWT.PUSH);
		//���ù��߰�ť��ͼƬ
		saveItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAVE_EDIT));
		//���ù��߰�ť�ϵ�����
		saveItem.setText("����");
		//���ù��߰�ť�ϵ���ʾ��Ϣ
		saveItem.setToolTipText("����");
		//������ӡ���߰�ť
		//new ToolItem ( toolBar , SWT.SEPARATOR);
		ToolItem printItem = new ToolItem ( toolBar , SWT.PUSH);
		printItem.setImage( ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT));
		printItem.setText("��ӡ");
		printItem.setToolTipText("��ӡ");
		//new ToolItem ( toolBar , SWT.SEPARATOR);
		//�����������߰�ť
		ToolItem helpItem = new ToolItem ( toolBar , SWT.PUSH);
		helpItem.setImage( ImageFactory.loadImage( display , ImageFactory.HELP_CONTENTS));
		helpItem.setText("����");
		helpItem.setToolTipText("����");
		
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
