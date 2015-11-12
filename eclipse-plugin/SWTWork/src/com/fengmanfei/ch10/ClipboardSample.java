package com.fengmanfei.ch10;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ClipboardSample {

	public static void main(String[] args) {
		Display display = new Display();
		//������������
		final Clipboard cb = new Clipboard(display);
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("Clipboard Sample");
		//���嵯��ʽ�˵�
		final Text content = new Text(shell, SWT.BORDER | SWT.MULTI | SWT.WRAP);
		Menu menu = new Menu(shell, SWT.POP_UP);
		//���Ʋ˵���
		final MenuItem copyItem = new MenuItem(menu, SWT.PUSH);
		copyItem.setText("����");
		//ע�Ḵ�Ʋ˵����¼�
		copyItem.addSelectionListener(new SelectionAdapter() {
			//��ѡ�иò˵���ʱ
			public void widgetSelected(SelectionEvent e) {
				//�����ʱδѡ���κ����֣���ִ�и��Ʋ���
				String selection = content.getSelectionText();
				if (selection.length() == 0)
					return;
				//������뵽���а��е��������ͣ���ͬʱ���ö������ͣ�����ָ����String����
				Object[] data = new Object[] { selection };
				Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
				//���ַ����뵽���а���
				cb.setContents(data, types);
			}
		});
		//ճ���˵���
		final MenuItem pasteItem = new MenuItem(menu, SWT.PUSH);
		pasteItem.setText("ճ��");
		//ע��ճ���˵����¼�
		pasteItem.addSelectionListener(new SelectionAdapter() {
			//��ѡ�иò˵�ʱ
			public void widgetSelected(SelectionEvent e) {
				//���ַ����Ӽ�������ȡ��
				String string = (String) (cb.getContents(TextTransfer.getInstance()));
				//����Ϊ�գ�����뵽�ı�����
				if (string != null)
					content.insert(string);
			}
		});
		//Ϊ�˵�ע���¼�
		menu.addMenuListener(new MenuAdapter() {
			//����ʾ�˵�ʱ
			public void menuShown(MenuEvent e) {
				//���ѡ�е��ı�
				String selection = content.getSelectionText();
				//���û��ѡ���κ��ı����򽫸��Ʋ˵�����Ϊ������
				copyItem.setEnabled(selection.length() > 0);
				//�����������Ƿ�֧���ı���������
				TransferData[] available = cb.getAvailableTypes();
				boolean enabled = false;
				for (int i = 0; i < available.length; i++) {
					if (TextTransfer.getInstance().isSupportedType(available[i])) {
						enabled = true;
						break;
					}
				}
				//���֧�֣�����ճ���˵���Ϊ����״̬
				pasteItem.setEnabled(enabled);
			}
		});
		content.setMenu(menu);

		shell.setSize(300, 150);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		//��������õ���ϵͳ��Դ��ʹ�������ֹ��ͷŵ�
		cb.dispose();
		display.dispose();
	}

}
