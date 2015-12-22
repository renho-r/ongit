package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CTabFolderSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("CTabFolder");
		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		shell.setLayout(layout);
		// ����CTabFolder����
		final CTabFolder tabFolder = new CTabFolder(shell, SWT.CLOSE
				| SWT.BORDER);
		// ����ѡ��Ĳ���
		tabFolder.setLayout(new FillLayout());
		// ����ѡ���ǩ�ĸ߶�
		tabFolder.setTabHeight(20);
		// �������£����Ҳ���
		tabFolder.marginHeight = 10;
		tabFolder.marginWidth = 10;
		for (int i = 1; i < 4; i++) {
			// ����CTabItemѡ���ǩ����
			CTabItem item = new CTabItem(tabFolder, SWT.NONE);
			// ����ѡ����ı�
			item.setText("ѡ� " + i);
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
