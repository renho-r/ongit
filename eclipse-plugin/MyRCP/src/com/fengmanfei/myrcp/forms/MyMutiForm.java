package com.fengmanfei.myrcp.forms;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class MyMutiForm extends FormEditor {

	public static final String ID = "com.fengmanfei.myrcp.forms.MyMutiForm";
	public MyMutiForm() {
		super();
	}
	//ʵ�ָ����еĳ��󷽷���
	//�ڸ÷����д���ÿ��ҳ��
	protected void addPages() {
		try {
			//�������ҳ��
			addPage(new FirstPage(this));
			addPage(new SecondPage(this));
			addPage(new MasterDetailPage(this));
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
	//����ñ༭��ʱ���ø÷���
	public void doSave(IProgressMonitor monitor) {
	}
	//���Ϊ�ñ༭��ʱ
	public void doSaveAs() {
	}
	//�Ƿ�������
	public boolean isSaveAsAllowed() {
		return false;
	}

}
