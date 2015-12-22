package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ProgreeBarTableSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		// ����������
		Table table = new Table(shell, SWT.BORDER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// ������ͷ
		for (int i = 0; i < 2; i++) {
			new TableColumn(table, SWT.NONE);
		}
		table.getColumn(0).setText("����");
		table.getColumn(1).setText("����");
		// ����10������
		for (int i = 0; i < 10; i++) {
			//����һ��
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText("���� " + i);
			//����һ��������
			ProgressBar bar = new ProgressBar(table, SWT.NONE);
			bar.setSelection((i + 1) * 10);
			//����һ���ɱ༭�ı�����
			TableEditor editor = new TableEditor(table);
			editor.grabHorizontal = true;
			editor.grabVertical = true;
			//���������󶨵���Ԫ����
			editor.setEditor(bar, item, 1);
		}
		table.getColumn(0).pack();
		table.getColumn(1).setWidth(100);
		table.pack();
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
