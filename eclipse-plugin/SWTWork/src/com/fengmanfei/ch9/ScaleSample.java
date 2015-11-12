package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Shell;

public class ScaleSample {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setLayout( new GridLayout());
		shell.setText("Scale");
		//����һ����ǩ��ʾ��ǰ��ѡ�е�ֵ
		final Label sliderValue = new Label ( shell , SWT.NONE);
		//�����̶�������
		final Scale scale = new Scale (shell, SWT.HORIZONTAL);
		scale.setMaximum(100);//�������ֵΪ100
		scale.setMinimum(0);//������СֵΪ0
		scale.setIncrement(1);//�����϶�����ʱ������ֵ
		scale.setPageIncrement(20);//���õ�������հ״�һ���ƶ���ֵ
		scale.setSelection(50);//���õ�ǰѡ�е�ֵ
		sliderValue.setText( "��ǰֵΪ"+scale.getSelection());
		scale.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				sliderValue.setText( "��ǰֵΪ"+scale.getSelection());
			}

		});
		shell.pack();
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch ())
				display.sleep ();
		}
		display.dispose ();

	}

}
