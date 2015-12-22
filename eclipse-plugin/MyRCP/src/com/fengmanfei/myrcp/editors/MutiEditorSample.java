package com.fengmanfei.myrcp.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;

public class MutiEditorSample extends MultiPageEditorPart {

	//�ñ༭���ı�ʶ
	public static final String ID = "com.fengmanfei.myrcp.editors.MutiEditorSample";
	private JsEditor page1 ;//�༭������
	private JsEditor page2 ;//�༭������
	private Label control1 ;//��ǩ����
	//�����г��󷽷�
	protected void createPages() {
		//����ҳ��ͱ�ǩ����
		page1 = new JsEditor();
		page2 = new JsEditor();
		control1 = new Label ( getContainer(), SWT.NONE);
		control1.setText("����һ����ǩ");
		try {
			//��ӵ�һҳ
			addPage( page1 , new JsEditorInput("One"));
			//����ѡ�������
			setPageText(0,"One");
			//��ӵڶ�ҳ
			addPage( page2 , new JsEditorInput("Two"));
			setPageText(1,"Two");
			//��ӵ���ҳ��Ϊһ����ǩ
			addPage(control1);
			setPageText(2,"Three");
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	public void doSave(IProgressMonitor monitor) {
		
	}

	public void doSaveAs() {
		
	}

	public boolean isSaveAsAllowed() {
		return false;
	}


}
