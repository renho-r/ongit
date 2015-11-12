package com.fengmanfei.ch15.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;

import com.fengmanfei.ch15.MainWindow;

public class PasteAction extends Action{
	public PasteAction( ){
		super();
	    setText("ճ��(&C)");
	    setToolTipText("ճ��");
	    setAccelerator( SWT.CTRL + 'V');
	    setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class,"icons\\paste.gif"));
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		MainWindow.getApp().getContent().paste();
	}
}
