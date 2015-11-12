package com.fengmanfei.myrcp.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import myRCP.MyRCPPlugin;

public class JsEditorInput implements IEditorInput {
	//������ַ�
	private String input ;
	public JsEditorInput ( String input ){
		this.input = input ;
	}
	//�Ƿ񽫱༭��������������ʼ�¼��
	public boolean exists() {
		return true;
	}
	//�������ݵ�ͼ��
	public ImageDescriptor getImageDescriptor() {
		return MyRCPPlugin.getImageDescriptor("icon/sample.gif");
	}
	//������Ϣ������
	public String getName() {
		return input;
	}
	//�Ƿ���Գ־û��ñ༭��
	public IPersistableElement getPersistable() {
		return null;
	}
	//���ñ༭����ǩ����ʾ��ʾ��Ϣ
	public String getToolTipText() {
		return input;
	}
	//�������������ص���Ķ���
	public Object getAdapter(Class adapter) {
		return null;
	}

}
