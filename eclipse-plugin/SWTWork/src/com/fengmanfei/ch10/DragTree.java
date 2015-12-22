package com.fengmanfei.ch10;

import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class DragTree {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		//����һ��������
		final Tree tree = createFolderTree(shell);
		//�����Ϸ�Դ����
		DragSource dragSource = new DragSource(tree, DND.DROP_MOVE|DND.DROP_COPY);
		//���ô��������Ϊ�ı���String����
		dragSource.setTransfer(new Transfer[] { TextTransfer.getInstance()});
		//ע���Ϸ�Դʱ���¼�����
		dragSource.addDragListener(new DragSourceListener() {
			public void dragStart(DragSourceEvent event) {
				if (tree.getSelectionCount() == 0)
					event.doit = false;
			}
			public void dragSetData(DragSourceEvent event) {
				if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
					event.data = tree.getSelection()[0].getText(0);
				}
			}
			public void dragFinished(DragSourceEvent event) {
					
			}
		});
		//�����Ϸ�Ŀ�����
		DropTarget dropTarget = new DropTarget(tree, DND.DROP_MOVE | DND.DROP_DEFAULT|DND.DROP_COPY);
		//����Ŀ�����ɴ������������
		dropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance()});
		//ע��Ŀ�������¼�����
		dropTarget.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT)
					event.detail = DND.DROP_COPY;
			}
			public void dragOperationChanged(DropTargetEvent event) {
				if (event.detail == DND.DROP_DEFAULT)
					event.detail = DND.DROP_COPY;
			}
			public void dragOver(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_EXPAND | DND.FEEDBACK_SELECT;
			}
			//���ɿ����ʱ�������¼�
			public void drop(DropTargetEvent event) {
				if (event.item == null)
					return;
				//���Ȼ��Ŀ���������ק�����ڵ�
				TreeItem eventItem = (TreeItem) event.item;
				if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
					//�������Դ���õ��ַ���
					String s = (String) event.data;
					//�ڵ�ǰλ�ò���һ���ڵ�
					TreeItem newItem = null ;
					if (eventItem.getParentItem()==null)
						newItem = new TreeItem(eventItem.getParent(),SWT.NONE);
					else
						newItem = new TreeItem(eventItem.getParentItem(),SWT.NONE);
					newItem.setText(s);
				}
			}

			public void dragLeave(DropTargetEvent event) {
			}
			public void dropAccept(DropTargetEvent event) {
			}

		});
		shell.setSize(300, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
	//������������Ŀ¼�ṹ����ʼ��������
	public static Tree createFolderTree(Composite parent) {
		Tree tree = new Tree(parent, SWT.BORDER | SWT.SINGLE);
		File root = new File("F:\\Temp");
		File[] files = root.listFiles();
		for (int i = 0; i < files.length; i++) {
			TreeItem item = new TreeItem(tree, SWT.NONE);
			item.setText(files[i].getName());
			if (files[i].isDirectory())
				setDirectory(files[i], item);
		}
		return tree;

	}
	//�����������������ݣ��ݹ���ø÷���
	public static void setDirectory(File file, TreeItem parent) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			TreeItem item = new TreeItem(parent, SWT.NONE);
			item.setText(files[i].getName());
			if (files[i].isDirectory())
				setDirectory(files[i], item);
		}
	}
}