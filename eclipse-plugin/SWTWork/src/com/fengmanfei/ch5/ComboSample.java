package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ComboSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("��Ͽ�");
		FillLayout layout = new FillLayout();
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		shell.setLayout(layout);

		final Combo combo = new Combo(shell, SWT.SIMPLE);
		String[] items = new String[4];
		for (int i = 0; i < items.length; i++)
			items[i] = "ѡ��" + i;
		combo.setItems(items);
		// ע������¼�
		combo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// �������������ļ�ͷ��������ѡ����һ��ѡ��
				if (e.keyCode == SWT.ARROW_LEFT)
					combo.select(combo.getSelectionIndex() - 1);
				// ������������ҵļ�ͷ��������ѡ����һ��ѡ��
				else if (e.keyCode == SWT.ARROW_RIGHT)
					combo.select(combo.getSelectionIndex() + 1);
			}
		});
		shell.setSize(200, 100);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
