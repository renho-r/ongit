package com.fengmanfei.ch15.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;

import com.fengmanfei.ch15.FileManager;
import com.fengmanfei.ch15.MainWindow;

public class NewAction extends Action {

	public NewAction( ){
		super();
	    setText("�½�(&N)");
	    this.setAccelerator( SWT.ALT + SWT.SHIFT + 'N');
	    setToolTipText("�½�");
	    setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class,"icons\\new.gif"));
	}
	/* ���� Javadoc��
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		MainWindow.getApp().getContent().setText("");
		MainWindow.getApp().setManager( new FileManager());
	}
	
}
