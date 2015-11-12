package com.fengmanfei.ch10;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class DragDropSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Drag and Drop Sample");
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		shell.setLayout(layout);
		// �������Ĳ�Ʒ���
		final Table productList = createProductTable(shell);
		// �����Ҳ�Ĳ�Ʒ���
		final Table shoppingCart = createCartTable(shell);
		// �����Ϸ�Դ
		DragSource source = new DragSource(productList, DND.DROP_MOVE | DND.DROP_COPY);
		// ���ô��������Ϊ�ı���String����
		source.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		// ע�ᵱ�϶�Դʱ�������¼�
		source.addDragListener(new DragSourceListener() {
			// ����ʼ�϶�Դ�ؼ�ʱ��
			public void dragStart(DragSourceEvent event) {
				if (productList.getSelectionCount() == 0)
					event.doit = false;
			}

			// ������ק�����д��������
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					// ��õ�ǰѡ�е�һ��
					TableItem item = productList.getSelection()[0];
					// ����Ʒ�Ͳ�Ʒ�ĵ��۱�ʾ���ַ�������ʽ���ö��ŷָ���
					// ����"CPU��1200"������ֵ��event.data
					event.data = item.getText(0) + "��" + item.getText(2);
				}
			}

			// ���϶���ɺ��ͷŹ�����������¼�
			public void dragFinished(DragSourceEvent event) {
			}
		});

		// �����Ϸŵ�Ŀ��ؼ�
		DropTarget target = new DropTarget(shoppingCart, DND.DROP_COPY | DND.DROP_DEFAULT);
		// ����Ŀ��ؼ������ܵĴ�������
		target.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		target.addDropListener(new DropTargetListener() {
			// �������뵽Ŀ��ؼ�������ʱ
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT)
					event.detail = DND.DROP_COPY;
			}

			// ������뿪Ŀ��ؼ�������ʱ
			public void dragLeave(DropTargetEvent event) {

			}

			// ���ı�event.detail����ʱ�������¼�
			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT)
					event.detail = DND.DROP_COPY;
			}

			// �������Ŀ��������ʱ
			public void dragOver(DropTargetEvent event) {
			}

			// �Ϸ���ɺ󴥷����¼�
			public void drop(DropTargetEvent event) {
				// ���Ȼ�õ�ȻĿ������
				TableItem item = (TableItem) event.item;
				if (item == null) {
					event.detail = DND.DROP_NONE;
					return;
				}
				// ���֧���ı��ʹ�������
				if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
					// ���Ȼ��Դ�����е��ַ������ݣ���������ͨ��dragSetData()�������õ�
					// �����ʱ��õ�����dataInfoΪ"CPU��1200";
					String dataInfo = (String) event.data;
					if (dataInfo == null)
						return;
					// ���Ƚ������ŷָ���ַ���������֮ǰ���ַ�Ϊ��Ʒ��������֮����ַ�Ϊ�۸�
					int index = dataInfo.indexOf("��");
					String name = dataInfo.substring(0, index);
					double price = 0.00d;
					try {
						price = Double.parseDouble(dataInfo.substring(index + 1));
					} catch (Exception e) {
						price = 0.00d;
					}
					// ���Ŀ����
					Table parent = item.getParent();
					TableItem it = null;
					// ѭ��Ŀ�����е�ÿһ��Ƿ��ﳵ���Ѿ�����˸ò�Ʒ
					for (int i = 0; i < parent.getItemCount(); i++) {
						TableItem temp = parent.getItem(i);
						if (temp.getText(0).equals(name)) {
							it = temp;
							break;
						}
					}
					// ���û�ҵ������½�һ�У�������1������ʾ�ܼ۸�
					if (it == null) {
						it = new TableItem(parent, SWT.NONE);
						it.setText(0, name);
						it.setText(1, "1");
						it.setText(2, "" + price);
					} else {// ����ҵ������¸Ĳ�Ʒ���������ܼ۸�
						int number = Integer.parseInt(it.getText(1)) + 1;
						double total = number * price;
						it.setText(1, "" + number);
						it.setText(2, "" + total);
					}
					// �����¹��ﳵ���ܼۺ�����
					TableItem sumItem = parent.getItem(0);
					sumItem.setText(1, Integer.parseInt(sumItem.getText(1)) + 1 + "");
					sumItem.setText(2, Double.parseDouble(sumItem.getText(2)) + price + "");
				}
			}

			public void dropAccept(DropTargetEvent event) {
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	// ������Ʒ�ı��
	public static Table createProductTable(Composite parent) {
		Table table = new Table(parent, SWT.FULL_SELECTION | SWT.SINGLE);
		String[] heads = { "��Ʒ����", "��λ", "�۸�" };
		for (int i = 0; i < heads.length; i++) {
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setText(heads[i]);
		}
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "CPU", "��", "1200.00" });
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "�ڴ�", "��", "255.00" });
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "�ʼǱ�", "̨", "9800.00" });
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (int i = 0; i < heads.length; i++) {
			table.getColumns()[i].pack();
		}
		return table;
	}

	// �������ﳵ���
	public static Table createCartTable(Composite parent) {
		Table table = new Table(parent, SWT.FULL_SELECTION);
		String[] heads = { "��Ʒ����", "����", "�ܼ۸�" };
		for (int i = 0; i < heads.length; i++) {
			TableColumn col = new TableColumn(table, SWT.NONE);
			col.setText(heads[i]);
		}
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "", "0", "0.00" });
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		for (int i = 0; i < heads.length; i++) {
			table.getColumns()[i].pack();
		}
		return table;
	}
}
