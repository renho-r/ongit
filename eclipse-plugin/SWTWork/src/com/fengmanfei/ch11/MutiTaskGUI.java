package com.fengmanfei.ch11;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class MutiTaskGUI {
	private Shell shell = null;
	private Table table = null;
	public MutiTaskGUI( ){
		//���췽���е��ó�ʼ�����ڵķ���
		init();
	}
	//��ʼ�����ڷ���
	public void init() {
		shell = new Shell();
		shell.setLayout(new GridLayout());
		shell.setText("���߳�");
		Button bt = new Button ( shell , SWT.NONE);
		bt.setText("��ʼһ������");
		// ����������
		table = new Table(shell, SWT.BORDER);
		table.setLayoutData( new GridData(SWT.FILL,SWT.FILL,true,true));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		String[] header = new String[]{"����","����","����"};
		// ������ͷ
		for (int i = 0; i < 3; i++) {
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setText( header[i] );
		}
		//���ñ�ͷ���
		table.getColumn(0).setWidth(80);
		table.getColumn(1).setWidth(150);
		table.getColumn(2).setWidth(80);
		shell.pack();
		//ע�ᴴ������ť�¼�
		bt.addSelectionListener( new SelectionAdapter(){
			//����������һ������ťʱ
			public void widgetSelected(SelectionEvent e) {
				//���ȴ���һ��Task����
				Task task = new Task ( table );
				//Ȼ���ٱ�������һ��
				task.createTableItem();
				//������������񣬸�����Ϊһ���߳�
				task.start();
			}
		});
	}
	//��ú��������Ե�getter��setter����
	public Shell getShell() {
		return shell;
	}
	public void setShell(Shell shell) {
		this.shell = shell;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
}
