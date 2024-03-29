package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class EclipseTabSample {

	public static void main(String[] args) {
		Display display = new Display();
		// 创建图片对象，该图片对象设置选项卡上的图标
		Image image = new Image(
				display,
				"F:\\javaDev\\eclipse\\plugins\\org.eclipse.platform_3.1.2\\intro\\css\\graphics\\icons\\etool\\samples.gif");
		final Shell shell = new Shell(display);
		shell.setText("仿Eclipse编辑区的选项卡");
		shell.setLayout(new GridLayout());
		// 创建自定义选项卡对象
		final CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
		// 设置选项卡的布局，通过布局的设置呈现出最大化和最小化的外观
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// 设置复杂的选项卡，也就是带有圆角的选项卡标签
		folder.setSimple(false);
		// 设置未选中标签，图标和关闭按钮的状态
		folder.setUnselectedImageVisible(true);
		folder.setUnselectedCloseVisible(true);
		// 设置前景色和背景色
		folder.setSelectionForeground(display.getSystemColor(SWT.COLOR_WHITE));
		folder.setSelectionBackground(display.getSystemColor(SWT.COLOR_BLUE));
		// 显示最大化和最小化按钮
		folder.setMinimizeVisible(true);
		folder.setMaximizeVisible(true);
		// 创建选项卡标签对象
		for (int i = 1; i < 5; i++) {
			CTabItem item = new CTabItem(folder, SWT.CLOSE);
			item.setText("选项卡 " + i);
			item.setImage(image);
			// 每个选项卡中放置一个Text文本框
			Text text = new Text(folder, SWT.MULTI | SWT.V_SCROLL
					| SWT.H_SCROLL);
			// 文本框中的文字带有\n表示，显示时换到下一行
			text.setText("这是第" + i + "页:\n该选项卡仿照Eclipse设计\n最大化和最小化按钮都可以使用");
			item.setControl(text);
		}
		// 注册选项卡事件
		folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
			// 当单击最小化按钮时触发的事件
			public void minimize(CTabFolderEvent event) {
				// 设置选项卡的状态为最小化，选项卡的状态决定显示在右上角的窗口按钮
				folder.setMinimized(true);
				// 改变选项卡的布局，呈现最小化状态
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false));
				// 刷新布局，否则重新设置的布局将不起作用
				shell.layout(true);
			}

			// 当单击最大化按钮时触发的事件
			public void maximize(CTabFolderEvent event) {
				folder.setMaximized(true);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						true));
				shell.layout(true);
			}

			// 当单击还原按钮时触发的事件
			public void restore(CTabFolderEvent event) {
				folder.setMinimized(false);
				folder.setMaximized(false);
				folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
						false));
				shell.layout(true);
			}
		});
		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		// 释放图片资源
		image.dispose();
		display.dispose();
	}

}
