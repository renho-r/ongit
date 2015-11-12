package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class ProgressBarSample {

	public static void main(String[] args) {
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("ProgressBar");
		shell.setLayout(new GridLayout());

		//����������ʵ��
		final ProgressBar progressBar = new ProgressBar(shell, SWT.HORIZONTAL);
		progressBar.setMaximum(100);//�������ֵ
		progressBar.setMinimum(0);//������Сֵ
		final int maximum = progressBar.getMaximum();//��ȡ���ֵ
		final int minimus = progressBar.getMinimum();//��ȡ��Сֵ
		//����һ���̣߳����߳�ÿ0.1�����һ�ι�������ֵ
		Runnable runnable = new Runnable() {
			public void run() {
				//�߳����е�����
				for (int i = minimus; i < maximum; i++) {
					try {
						//���߳�˯��0.1��
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//���ʹ���������д�����¹�������ֵ������ʱ�����Invalid thread access
					//progressBar.setSelection(progressBar.getSelection() + 1);
					//��UI�̸߳��¹�������ֵ
					display.asyncExec(new Runnable() {
						//��Ҳ��һ���̣߳����̵߳Ĺ����Ǹ��¹�������ֵ��һ˲��ͽ�����
						public void run() {
							if (progressBar.isDisposed())
								return;
							progressBar.setSelection(progressBar.getSelection() + 1);
						}
					});
				}
			}
		};
		//��������߳�
		new Thread(runnable).start();
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();

	}

}
