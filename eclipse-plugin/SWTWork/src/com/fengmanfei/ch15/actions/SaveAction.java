package com.fengmanfei.ch15.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;

import com.fengmanfei.ch15.FileManager;
import com.fengmanfei.ch15.MainWindow;

public class SaveAction extends Action{
	public SaveAction() {
		super();
		setText("����(&S)");
		setToolTipText("�����ļ�");
		setImageDescriptor( ImageDescriptor.createFromFile(NewAction.class,"icons\\save.gif"));
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		final FileManager fileManager = MainWindow.getApp().getManager();
		//����ļ�û���޸Ĺ����򲻱���
		if (!fileManager.isDirty())
			return ;
		//������½����ļ�������Ҫѡ�񱣴��·��
		if ( fileManager.getFileName() == null ){
			FileDialog saveDialog = new FileDialog( MainWindow.getApp().getShell(),SWT.SAVE);
			saveDialog.setText("��ѡ����Ҫ������ļ�");
			saveDialog.setFilterPath("F:\\");
			saveDialog.setFilterExtensions(new String[] { "*.java", "*.*" });
			String saveFile = saveDialog.open();
			if ( saveFile != null )
			{
				fileManager.setFileName( saveFile );
				fileManager.setContent( MainWindow.getApp().getContent().getText() );
				fileManager.save( fileManager.getFileName());
			}
			fileManager.setDirty( false );
			return ;
		}
		//����Ǵ򿪵��ļ��������Ի���ȷ�ϱ���
		if (fileManager.getFileName()!= null){
			MessageBox box = new MessageBox( MainWindow.getApp().getShell() ,SWT.ICON_QUESTION|SWT.YES|SWT.NO);
			box.setText("����");
			box.setMessage("��ȷ��Ҫ�����ļ���");
			int choice = box.open();
			if (choice==SWT.NO)
				return;
			fileManager.setContent( MainWindow.getApp().getContent().getText() );
			fileManager.save( fileManager.getFileName());
			fileManager.setDirty( false );
			return ;
		}
	}

}
