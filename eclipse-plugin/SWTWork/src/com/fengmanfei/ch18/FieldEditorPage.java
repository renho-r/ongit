package com.fengmanfei.ch18;

import org.eclipse.jface.preference.*;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;

public class FieldEditorPage extends FieldEditorPreferencePage {

	public FieldEditorPage() {
		super(GRID);//ҳ�����ʽ��������ʹ��FLAT����
	}
	//�÷���Ϊʵ�ָ����еĳ��󷽷����ڸ÷������������ı༭������
	protected void createFieldEditors() {

		//����һ���ַ��ͱ༭������
		StringFieldEditor userName = new StringFieldEditor(
				Constants.USER_NAME, //ѡ���keyֵ
				"��¼�û���:", //��ʾ�ı�ǩ��
				getFieldEditorParent());//���ֶα༭���ĸ������
		//���ø��෽�������÷�����ӵ���ҳ��
		addField(userName);
		/*
		BooleanFieldEditor bfe = new BooleanFieldEditor("show","Boolean",getFieldEditorParent());
		addField(bfe);
		ColorFieldEditor cfe = new ColorFieldEditor("color","Color",getFieldEditorParent());
		addField(cfe);
		FontFieldEditor ffe = new FontFieldEditor("font","Font",getFieldEditorParent());
		addField(ffe);
		PathEditor pfe = new PathEditor("path","Path","��ѡ����ѡ��·��",getFieldEditorParent());
		addField(pfe);
		RadioGroupFieldEditor rgfe = new RadioGroupFieldEditor(
				"group", //ѡ���key
				"RadioGroup",//�������ʾ���ı�
				2,//һ����ʾ�ĵ�ѡ��ť����
				new String[][] { { "Radio one", "one"},	{"Radio two", "two"},{"Radio three", "three"}	},//��ѡ��ť�ı�ǩ��ֵ
				getFieldEditorParent(),//��������
				true);//true��ʾʹ�÷�����壬false��ʹ����ͨ�����
		addField(rgfe);
		ScaleFieldEditor sfe = new ScaleFieldEditor("scale","Scale",getFieldEditorParent(),0,100,5,10);
		addField(sfe);

		IntegerFieldEditor ife = new IntegerFieldEditor("int","Int",getFieldEditorParent());
		addField(ife);
		DirectoryFieldEditor dfe = new DirectoryFieldEditor("dirctory","Directory",getFieldEditorParent());
		addField(dfe);
		FileFieldEditor filefe = new FileFieldEditor("file","File",getFieldEditorParent());
		addField(filefe);
		*/
	}
}
