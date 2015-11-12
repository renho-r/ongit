package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TabFolderSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabFolder");
		shell.setLayout(new FillLayout());
		// ����TabFolder����
		final TabFolder tabFolder = new TabFolder(shell, SWT.TOP);
		// ����ѡ��Ĳ���
		tabFolder.setLayout(new FillLayout());
		for (int i = 1; i < 4; i++) {
			// ����TabItemѡ���ǩ����
			TabItem item = new TabItem(tabFolder, SWT.NONE);
			// ����ѡ����ı�
			item.setText("ѡ� " + i);
			// item.setImage( new Image(display,"F:\\javaDev\\eclipse\\plugins\\org.eclipse.platform_3.1.2\\eclipse.png") );
			Text t = new Text(tabFolder, SWT.MULTI);
			t.setText("���ǵ�" + i + "ҳ");
			// ����ѡ������ƵĿؼ�
			item.setControl(t);
		}
		tabFolder.pack();
		shell.setSize(300, 200);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
