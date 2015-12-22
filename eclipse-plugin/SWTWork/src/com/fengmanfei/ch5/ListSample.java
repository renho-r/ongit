package com.fengmanfei.ch5;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ListSample {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Listʾ��");

		String[] itemLeft = new String[20]; // ���屣������б��е�����
		String[] itemRight = new String[0]; // ���屣���Ҳ��б��е�����
		// ��ʼ������ַ�������
		for (int i = 0; i < 20; i++)
			itemLeft[i] = "item" + i;

		// ��������б���ѡ�������Ҵ��д�ֱ������
		final List left = new List(shell, SWT.MULTI | SWT.V_SCROLL);
		left.setBounds(10, 10, 100, 180);// ����λ�úʹ�С
		left.setItems(itemLeft);// ����ѡ������
		left.setToolTipText("��ѡ���б���");// ������ʾ

		// �����Ҳ��б���ѡ�������Ҵ��д�ֱ������
		final List right = new List(shell, SWT.MULTI | SWT.V_SCROLL);
		right.setBounds(170, 10, 100, 180);
		right.setItems(itemRight);
		right.setToolTipText("��ѡ����б���");

		// �����¼������࣬Ϊ�ڲ���
		SelectionAdapter listener = new SelectionAdapter() {
			// ��ť�����¼��Ĵ�����
			public void widgetSelected(SelectionEvent e) {
				// ȡ�ô����¼��Ŀؼ�����
				Button b = (Button) e.widget;
				if (b.getText().equals(">"))// �����">"��ť
					verifyValue(left.getSelection(), left, right);
				else if (b.getText().equals(">>"))// �����">>"��ť
					verifyValue(left.getItems(), left, right);
				else if (b.getText().equals("<"))// �����"<"��ť
					verifyValue(right.getSelection(), right, left);
				else if (b.getText().equals("<<"))// �����"<"��ť
					verifyValue(right.getItems(), right, left);
				else if (b.getText().equals("��"))// �����"��"��ť
				{
					// ��õ�ǰѡ��ѡ�������ֵ
					int index = right.getSelectionIndex();
					if (index <= 0)// ���û��ѡ�У��򷵻�
						return;
					// ���ѡ����ѡ��ֵ����õ�ǰѡ���ֵ
					String currentValue = right.getItem(index);
					// ��ѡ�е�ѡ������һ��ѡ���ֵ
					right.setItem(index, right.getItem(index - 1));
					right.setItem(index - 1, currentValue);
					// �趨��һ��ѡ��Ϊѡ��״̬
					right.setSelection(index - 1);

				} else if (b.getText().equals("��"))// �����"��"��ť
				{
					// �����ư�ť���߼���ͬ
					int index = right.getSelectionIndex();
					if (index >= right.getItemCount() - 1)
						return;
					String currentValue = right.getItem(index);
					right.setItem(index, right.getItem(index + 1));
					right.setItem(index + 1, currentValue);
					right.setSelection(index + 1);
				}
			}

			// �ı������б�ֵ
			public void verifyValue(String[] select, List from, List to) {
				// ѭ������ѡ�е�ѡ��ֵ
				for (int i = 0; i < select.length; i++) {
					// ��һ���б����Ƴ���ѡ��ֵ
					from.remove(select[i]);
					// ��ӵ���һ���б���
					to.add(select[i]);
				}

			}

		};

		// �������ư�ť
		Button bt1 = new Button(shell, SWT.NONE);
		bt1.setText(">");
		bt1.setBounds(130, 20, 25, 20);
		// ��Ϊ��ťע���¼��������İ�ť����
		bt1.addSelectionListener(listener);

		Button bt2 = new Button(shell, SWT.NONE);
		bt2.setText(">>");
		bt2.setBounds(130, 55, 25, 20);
		bt2.addSelectionListener(listener);

		Button bt3 = new Button(shell, SWT.NONE);
		bt3.setText("<<");
		bt3.setBounds(130, 90, 25, 20);
		bt3.addSelectionListener(listener);

		Button bt4 = new Button(shell, SWT.NONE);
		bt4.setText("<");
		bt4.setBounds(130, 125, 25, 20);
		bt4.addSelectionListener(listener);

		Button bt5 = new Button(shell, SWT.NONE);
		bt5.setText("��");
		bt5.setBounds(300, 70, 25, 20);
		bt5.addSelectionListener(listener);

		Button bt6 = new Button(shell, SWT.NONE);
		bt6.setText("��");
		bt6.setBounds(300, 105, 25, 20);
		bt6.addSelectionListener(listener);

		shell.setSize(350, 250);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
