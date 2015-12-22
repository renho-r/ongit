package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;

public class SliderSample {

	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setLayout( new GridLayout());
		shell.setText("Slider");
		//����һ����ǩ��ʾ��ǰ��ѡ�е�ֵ
		final Label sliderValue = new Label ( shell , SWT.NONE);
		//�����������
		final Slider slider = new Slider (shell, SWT.HORIZONTAL);
		slider.setMaximum(100);//�������ֵΪ100
		slider.setMinimum(0);//������СֵΪ0
		slider.setIncrement(1);//����ÿ�ε�����ͷʱ������ֵ
		slider.setThumb(10);//���û���Ĵ�С
		slider.setPageIncrement(20);//���õ�������հ״�һ���ƶ���ֵ
		slider.setSelection(50);
		sliderValue.setText( "��ǰֵΪ"+slider.getSelection());
		slider.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				String string = "SWT.NONE";
				switch (event.detail) {
					case SWT.DRAG: string = "SWT.DRAG"; break;
					case SWT.HOME: string = "SWT.HOME"; break;
					case SWT.END: string = "SWT.END"; break;
					case SWT.ARROW_DOWN: string = "SWT.ARROW_DOWN"; break;
					case SWT.ARROW_UP: string = "SWT.ARROW_UP"; break;
					case SWT.PAGE_DOWN: string = "SWT.PAGE_DOWN"; break;
					case SWT.PAGE_UP: string = "SWT.PAGE_UP"; break;
				}
				System.out.println ("�������¼�Ϊ " + string);
				sliderValue.setText( "��ǰֵΪ"+slider.getSelection());
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
