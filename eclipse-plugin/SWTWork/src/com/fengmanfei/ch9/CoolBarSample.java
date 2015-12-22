package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.util.ImageFactory;

public class CoolBarSample {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText("CoolBar");
		shell.setLayout( new GridLayout());
		Composite tool = new Composite( shell ,SWT.NONE);
		tool.setLayoutData(new GridData(SWT.LEFT,SWT.TOP,true ,false));
		//������϶��Ĺ���������
		CoolBar coolBar = new CoolBar (tool, SWT.FLAT);
		//����������������
	    createItem(display ,coolBar);
	    createItem(display,coolBar);
		coolBar.pack ();
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
	public static CoolItem createItem(Display display ,CoolBar coolBar) {
		//����һ��������
	    ToolBar toolBar = createToolBar(display, coolBar);
	    //��ù������Ĵ�С
	    Point size = toolBar.getSize();
	    //����һ��CoolItem����
	    CoolItem item = new CoolItem(coolBar, SWT.NONE);
	    //���������󶨵��������������
	    item.setControl(toolBar);
	    //���㹤��������ʵĴ�С
	    Point preferred = item.computeSize(size.x, size.y);
	    //���ô�С
	    item.setPreferredSize(preferred);
	    return item;
	}
	public static ToolBar createToolBar(Display display, CoolBar coolBar) {
		ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT);
		//�������湤�߰�ť
		ToolItem saveItem = new ToolItem ( toolBar , SWT.PUSH);
		//���ù��߰�ť��ͼƬ
		saveItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAVE_EDIT));
		//���ù��߰�ť�ϵ�����
		saveItem.setText("����");
		//���ù��߰�ť�ϵ���ʾ��Ϣ
		saveItem.setToolTipText("����");
		//������ӡ���߰�ť
		ToolItem printItem = new ToolItem ( toolBar , SWT.PUSH);
		printItem.setImage( ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT));
		printItem.setText("��ӡ");
		printItem.setToolTipText("��ӡ");
		//�����������߰�ť
		ToolItem helpItem = new ToolItem ( toolBar , SWT.PUSH);
		helpItem.setImage( ImageFactory.loadImage( display , ImageFactory.HELP_CONTENTS));
		helpItem.setText("����");
		helpItem.setToolTipText("����");
	    toolBar.pack();
		return toolBar;
	}
}
