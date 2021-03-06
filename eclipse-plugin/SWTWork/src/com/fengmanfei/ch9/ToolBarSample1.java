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
		//创建工具栏对象，使用SWT.NONE样式
		final ToolBar toolBar = new ToolBar (tool, SWT.FLAT);
		
		//创建保存工具按钮
		ToolItem saveItem = new ToolItem ( toolBar , SWT.PUSH);
		//设置工具按钮的图片
		saveItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAVE_EDIT));
		saveItem.setHotImage(ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT) );
		//设置工具按钮上的文字
		saveItem.setText("保存");
		//设置工具按钮上的提示信息
		saveItem.setToolTipText("保存");
		//创建打印工具按钮
		
		ToolItem printItem = new ToolItem ( toolBar , SWT.PUSH);
		printItem.setImage( ImageFactory.loadImage( display , ImageFactory.PRINT_EDIT));
		printItem.setText("打印");
		printItem.setToolTipText("打印");
		
		new ToolItem ( toolBar , SWT.SEPARATOR);
		//创建帮助工具按钮，定义为下拉式。使用SWT.DROP_DOWN样式
		final ToolItem helpItem = new ToolItem ( toolBar , SWT.DROP_DOWN);
		helpItem.setImage( ImageFactory.loadImage( display , ImageFactory.HELP_CONTENTS));
		helpItem.setText("帮助");
		helpItem.setToolTipText("帮助");
		
		//定义一个弹出式菜单，使用常量SWT.POP_UP
		final Menu helpMenu = new Menu( shell , SWT.POP_UP);
		//定义菜单中的菜单项
		MenuItem welcomeItem = new MenuItem(helpMenu,SWT.PUSH);
		welcomeItem.setText("欢迎");
		welcomeItem.setImage( ImageFactory.loadImage( display , ImageFactory.ECLIPSE) );
		
		new MenuItem( helpMenu ,SWT.SEPARATOR);
		
		MenuItem updatetem = new MenuItem(helpMenu,SWT.PUSH);
		updatetem.setText("在线更新");
		
		MenuItem aboutItem = new MenuItem(helpMenu,SWT.PUSH);
		aboutItem.setText("关于我们");
		aboutItem.setImage( ImageFactory.loadImage( display , ImageFactory.SAMPLES) );
		//为下拉工具栏注册单击下拉箭头事件
		helpItem.addListener(SWT.Selection,new Listener(){

			public void handleEvent(Event event) {
				//如果触发的事件为单击按钮
				if (event.detail==SWT.ARROW)
				{
					//获得帮助按钮所在坐标位置和大小，相对于父窗口
					Rectangle rect = helpItem.getBounds ();
					Point pt = new Point (rect.x, rect.y + rect.height);//计算菜单出现的起始位置
					pt = toolBar.toDisplay (pt);//将该点转化为于屏幕的相对位置
					helpMenu.setLocation (pt.x, pt.y);//设置菜单显示的位置
					helpMenu.setVisible (true);//显示菜单
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
		//释放图片资源
		ImageFactory.dispose();
		display.dispose ();

	}

}
