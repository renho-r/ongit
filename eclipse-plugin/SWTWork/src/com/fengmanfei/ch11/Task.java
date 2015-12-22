package com.fengmanfei.ch11;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.fengmanfei.util.ImageFactory;

//��Task��̳���Thread�����Ҹ�����run()����
public class Task extends Thread {
	//�����һЩ����
	private Table table = null;
	//�Ƿ�ֹͣ�ı�־
	private boolean done = false;
	//��������������
	private ProgressBar bar = null;
	private int min = 0;
	private int max = 100;
	public Task(Table table) {
		this.table = table;
	}
	//��������е�һ��
	public void createTableItem() {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(this.getName());
		item.setImage(ImageFactory.loadImage(table.getDisplay(), ImageFactory.PROGRESS_TASK));
		// ����һ��������
		bar = new ProgressBar(table, SWT.NONE);
		bar.setMinimum(min);
		bar.setMaximum(max);
		// ����һ���ɱ༭�ı�����
		TableEditor editor = new TableEditor(table);
		editor.grabHorizontal = true;
		editor.grabVertical = true;
		// ���������󶨵��ڶ�����
		editor.setEditor(bar, item, 1);
		//���´���һ���ɱ༭�ı�����
		editor = new TableEditor(table);
		editor.grabHorizontal = true;
		editor.grabVertical = true;
		//����һ����ť
		Button stop = new Button(table, SWT.NONE);
		stop.setText("Stop");
		editor.setEditor(stop, item, 2);
		stop.addSelectionListener(new SelectionAdapter() {
			//��ֹͣ��ť����ʱ������ֹͣ���true
			public void widgetSelected(SelectionEvent e) {
				if (!isDone())
					setDone(true);
			}
		});
	}
	//�̷߳����壬��ǰ�浥���Ľ������ĳ�������
	public void run() {
		for (int i = min; i < max; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			table.getDisplay().asyncExec(new Runnable() {
				public void run() {
					if (bar.isDisposed())
						return;
					bar.setSelection(bar.getSelection() + 1);
				}
			});
			//���ֹͣ����������߳�
			if (isDone()) {
				break;
			}
		}
	}
	//��ú��������Ե�getter��setter����
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
}
