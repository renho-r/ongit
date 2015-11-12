package com.fengmanfei.ch15.actions;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import com.fengmanfei.ch15.FileManager;
import com.fengmanfei.ch15.MainWindow;

public class OpenAction extends Action {

	public OpenAction() {
		super();
		setText("��(&O)");
		setToolTipText("���ļ�");
		setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class,"icons\\open.gif"));
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		//��һ���ļ��Ի���ѡ��һ���ļ�
		FileDialog dialog = new FileDialog(MainWindow.getApp().getShell(), SWT.OPEN);
		dialog.setFilterExtensions(new String[] { "*.java", "*.*" });
		final String name = dialog.open();
		if ((name == null) || (name.length() == 0))
			return;
		//����һ��FileManager���󣬸ö����װ�˴��ļ��ж�ȡ�ַ����ķ���
		final FileManager fileManager = MainWindow.getApp().getManager();
		try {
			//����һ���̴߳��ļ�
			ModalContext.run(new IRunnableWithProgress() {
				//�߳����е�����
				public void run(IProgressMonitor progressMonitor) {
					progressMonitor.beginTask("���ļ�", IProgressMonitor.UNKNOWN);
					fileManager.load(name);
					//Ϊ��ģ��һ���ϴ���ļ����ø��߳���Ϣ1�롣
					//ȡ����ע�����п��Կ����������
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					progressMonitor.done();
				}
			}, true, MainWindow.getApp().getStatusLineManager().getProgressMonitor(), MainWindow.getApp().getShell().getDisplay());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//װ�غ��ַ���ʾ���ı�����
		MainWindow.getApp().getContent().setText(fileManager.getContent());
		//����״̬����ʾ��Ϊ�򿪵��ļ�Ŀ¼
		MainWindow.getApp().getStatusLineManager().setMessage("��ǰ�򿪵��ļ��ǣ�"+name);
	}

}
