package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.util.ImageFactory;

public class TreeSample {

	public static void main(String[] args) {

		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Tree Sample");
		shell.setLayout(new FillLayout());
		// ����һ��������
		final Tree tree = new Tree(shell, SWT.BORDER | SWT.SINGLE);
		// ��������һ�����ڵ�
		TreeItem root = new TreeItem(tree, SWT.NULL);
		root.setText("���ڵ�");
		// ��������ڵ�
		TreeItem child1 = new TreeItem(root, SWT.NULL);
		child1.setText("����1");
		TreeItem child2 = new TreeItem(root, SWT.NULL);
		child2.setText("����2");
		TreeItem child3 = new TreeItem(root, SWT.NULL);
		child3.setText("����3");

		TreeItem child11 = new TreeItem(child1, SWT.NULL);
		child11.setText("����11");
		TreeItem child12 = new TreeItem(child1, SWT.NULL);
		child12.setText("����12");

		TreeItem child111 = new TreeItem(child11, SWT.NULL);
		child111.setText("����111");
		TreeItem child112 = new TreeItem(child11, SWT.NULL);
		child112.setText("����112");
		// ����convertImage��������������ͼ��
		convertImage(tree);
		// Ϊ��ע���������¼�
		tree.addTreeListener(new TreeListener() {
			// ���۵����ڵ�ʱ
			public void treeCollapsed(TreeEvent e) {
				// ���Ȼ�ô����¼���TreeItem
				TreeItem item = (TreeItem) e.item;
				// ���ýڵ��ͼ������Ϊ�ر�״̬
				item.setImage(ImageFactory.loadImage(tree.getDisplay(),
						ImageFactory.TOC_CLOSED));
			}

			// ��չ�����ڵ�ʱ
			public void treeExpanded(TreeEvent e) {
				TreeItem item = (TreeItem) e.item;
				item.setImage(ImageFactory.loadImage(tree.getDisplay(),
						ImageFactory.TOC_OPEN));
			}

		});
		/********************************************************
		//����һ���ɱ༭��TreeEditor����
		final TreeEditor editor = new TreeEditor(tree);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 30;
		//ע��ѡ���¼�
		tree.addSelectionListener(new SelectionAdapter() {
			//�����˫���ڵ�ʱʹ�ڵ�ɱ༭
			public void widgetDefaultSelected(SelectionEvent e) {
				//�ͷ�֮ǰ�༭�Ŀؼ�
				Control oldEditor = editor.getEditor();
				if (oldEditor != null) oldEditor.dispose();
				//��ô����¼���TreeItem�����Ϊnull������
				TreeItem item = (TreeItem)e.item;
				if (item == null) return;
				//����һ���ı�����Ϊ�༭�ڵ�ʱ���������
				Text newEditor = new Text(tree, SWT.NONE);
				//�����ڵ��ֵ��ֵ���ı���
				newEditor.setText(item.getText());
				//���ı����ֵ�ı�ʱ��Ҳ��Ӧ�ĸð������ڵ����ݵ�ֵ
				newEditor.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						Text text = (Text)editor.getEditor();
						editor.getItem().setText(text.getText());
					}
				});
				newEditor.selectAll();//ѡ�������ı���
				newEditor.setFocus();//������������Ϊ���ı���
				//�����ڵ����ı���ڵ��
				editor.setEditor(newEditor, item);
			}

		});
		****************************************************************/
		/***************************************************************
		//Ϊ������5��
		for ( int i=0;i<5 ;i++){
			TreeColumn column = new TreeColumn( tree , SWT.NONE);
			column.setText("column"+i);
		}
		for ( int i=0;i<tree.getColumnCount() ;i++)
		  tree.getColumn(i).pack();
		//���������߿ɼ�
		tree.setLinesVisible( true );
		//���ñ�ͷ�ɼ�
		tree.setHeaderVisible( true );
		***************************************************************/
		shell.setSize(200, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		ImageFactory.dispose();
		display.dispose();
	}

	// ������ͼ��ķ���
	public static void convertImage(Tree tree) {
		// �������ֻ��һ�����ڵ�
		TreeItem[] items = tree.getItems();
		// ���ȸ��ݸ��ڵ��״̬����ͼ��
		if (items[0].getExpanded())// ����ýڵ�Ϊչ��״̬
			items[0].setImage(ImageFactory.loadImage(tree.getDisplay(),
					ImageFactory.TOC_OPEN));
		else
			// �������Ϊ�۵�״̬
			items[0].setImage(ImageFactory.loadImage(tree.getDisplay(),
					ImageFactory.TOC_CLOSED));
		// ���øø��ڵ��ͼ��
		setChildImage(items[0]);
	}

	// ����һ���ڵ�ķ������÷����ǳ���Ҫ��Ҫ���÷����ĵݹ��÷�
	// ����item���԰ѵ������������е�ĳһ��TreeItem
	public static void setChildImage(TreeItem item) {
		// ���Ȼ�ø�TreeItem��������TreeItem
		TreeItem[] items = item.getItems();
		// ѭ��ÿһ��TreeItem
		for (int i = 0; i < items.length; i++) {
			// ������TreeItem��û������
			if (items[i].getItems().length == 0)
				items[i].setImage(ImageFactory.loadImage(item.getDisplay(),
						ImageFactory.TOPIC));
			else {// ������TreeItem�ж������
				// ������TreeItem��չ��״̬��������չ����ͼƬ
				if (items[i].getExpanded())
					items[i].setImage(ImageFactory.loadImage(item.getDisplay(),
							ImageFactory.TOC_OPEN));
				else
					// �����������۵���ͼƬ
					items[i].setImage(ImageFactory.loadImage(item.getDisplay(),
							ImageFactory.TOC_CLOSED));
				// ҪΪ��TreeItem����������ͼ�꣬�ݹ����setChildImage����
				setChildImage(items[i]);
			}
		}
	}

}
