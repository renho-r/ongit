package com.fengmanfei.ch6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class SashFormSample {

	public static void main(String[] args) {
		final Display display = new Display ();
		Shell shell = new Shell(display);
		shell.setLayout (new FillLayout());
		shell.setText("SashForm");

		//�����������������ʽΪˮƽ����
		SashForm form = new SashForm(shell,SWT.HORIZONTAL|SWT.BORDER);
		form.setLayout(new FillLayout());
		//��������1�����
		Composite child1 = new Composite(form,SWT.NONE);
		child1.setLayout(new FillLayout());
		new Text(child1,SWT.MULTI).setText("����1");
		//��������2�����
		Composite child2 = new Composite(form,SWT.NONE);
		child2.setLayout(new FillLayout());
		new Text(child2,SWT.MULTI).setText("����2");
		
		form.setWeights(new int[] {30,70});
		//form.setMaximizedControl( child1 );
		//form.setMaximizedControl( null );
		shell.setSize( 200,150);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();

	}

}
