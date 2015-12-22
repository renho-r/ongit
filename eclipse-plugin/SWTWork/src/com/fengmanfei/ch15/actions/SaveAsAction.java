package com.fengmanfei.ch15.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import com.fengmanfei.ch15.FileManager;
import com.fengmanfei.ch15.MainWindow;

public class SaveAsAction extends Action {
	public SaveAsAction() {
		super();
		setText("���Ϊ(&A)");
		setToolTipText("���Ϊ");
		setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\saveas.gif"));
	}
	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		final FileManager fileManager = MainWindow.getApp().getManager();
		//��������Ի���
		FileDialog saveDialog = new FileDialog( MainWindow.getApp().getShell(),SWT.SAVE);
		saveDialog.setText("��ѡ����Ҫ������ļ�");
		saveDialog.setFilterPath("F:\\");
		saveDialog.setFilterExtensions(new String[] { "*.java", "*.*" });
		String saveFile = saveDialog.open();
		if ( saveFile != null )
		{
			fileManager.setFileName( saveFile );
			fileManager.setContent( MainWindow.getApp().getContent().getText() );
			fileManager.save( fileManager.getFileName());//�����ļ�
		}
		fileManager.setDirty( false );
		return ;
	}

}
