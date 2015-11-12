package com.fengmanfei.ch21;

import java.io.IOException;
import org.eclipse.swt.widgets.Display;

public class JSEditorTestDrive {
	public static void main(String[] args) {
		//���������ڶ���
		JSEditor jsApp = new JSEditor();
		//Ϊ�����ڶ���������ѡ�����
		//��ѡ�����ͨ��ResourceManager�еľ�̬�������
		jsApp.setPreference(ResourceManager.getPreferenceStore() );
		//��Ϊ��ѡ������ע��ѡ��ı������
		ResourceManager.getPreferenceStore().addPropertyChangeListener(jsApp);
		jsApp.setBlockOnOpen(true);
		jsApp.open();
		Display.getCurrent().dispose();
		//���ڹرպ󱣴����õ���ѡ��
		try {
			ResourceManager.getPreferenceStore().save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
