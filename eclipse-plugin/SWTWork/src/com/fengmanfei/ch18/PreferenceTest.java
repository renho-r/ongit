package com.fengmanfei.ch18;

import java.io.IOException;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.preference.IPreferencePage;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.preference.PreferenceNode;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.widgets.Display;

public class PreferenceTest {

	public static void main(String[] args) {
		Display display = new Display();
		//����һ��PreferenceManager����
		PreferenceManager manager = new PreferenceManager();
		//����һ���ڵ����
		PreferenceNode nodeOne = new PreferenceNode("System", "ϵͳ����", null, SystemSettingPage.class.getName());
		//���ýڵ���ӵ����ڵ���
		manager.addToRoot(nodeOne);
		//���������ڵ����
		PreferenceNode one = new PreferenceNode("one", "��һҳ", null, PageOne.class.getName());
		PreferenceNode two = new PreferenceNode("two", "�ڶ�ҳ", null, PageTwo.class.getName());
		//����һҳ�ڵ㸽�ӵ�System·����
		manager.addTo("System",one);
		//���ڶ�ҳ�ڵ㸽�ӵ�System.one·����
		manager.addTo("System.one",two);
		PreferenceNode editorOne = new PreferenceNode("one", "�༭�ֶ�", null, FieldEditorPage.class.getName());
		manager.addToRoot(editorOne);
		/*********************
		//�ڶ�ҳ�ڵ�Ϊ��һҳ�ڵ���ӽڵ�
		one.add( two );
		//��һҳ�ڵ�Ϊϵͳ���ýڵ���ӽڵ�
		nodeOne.add(one);
		**********************/
		//manager.addTo("System",one);
		//manager.addTo("System.one",two);
		//����һ����ѡ��Ի��򣬲���manager��Ϊ��������
		PreferenceDialog dlg = new PreferenceDialog(null, manager);
		//ע��ҳ���л��¼�
		dlg.addPageChangedListener( new IPageChangedListener(){
			//��ҳ���л�ʱ
			public void pageChanged(PageChangedEvent event) {
				//��õ�ǰҳ��
				IPreferencePage page = (IPreferencePage)event.getSelectedPage();
				//�����ǰҳ��ı���
				System.out.println(page.getTitle());
			}
			
		});
		//��������ѡ������ֵ����
		PreferenceStore preferenceStore = new PreferenceStore("F:\\myPreference.properties");
		try {
			//װ�ظ��ļ��е�����ֵ
			preferenceStore.load();
			//�������ø�ֵ���öԻ���
			dlg.setPreferenceStore(preferenceStore);
			//�򿪶Ի���
			dlg.open();
			//���رնԻ���󣬱��浱ǰ����
			preferenceStore.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		display.dispose();
	}
}
