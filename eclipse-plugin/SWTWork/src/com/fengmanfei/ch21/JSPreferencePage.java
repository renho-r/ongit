package com.fengmanfei.ch21;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FontFieldEditor;

public class JSPreferencePage extends FieldEditorPreferencePage{

	private ColorFieldEditor keyword;
	private ColorFieldEditor comment;
	private ColorFieldEditor string;
	private ColorFieldEditor object;
	private FontFieldEditor codeFont;
	public JSPreferencePage() {
		super(GRID);
	}

	protected void createFieldEditors() {
		keyword = new ColorFieldEditor(Constants.COLOR_KEYWORD,"�ؼ�����ɫ��",getFieldEditorParent());
		addField(keyword);
		comment = new ColorFieldEditor(Constants.COLOR_COMMENT,"ע����ɫ��",getFieldEditorParent());
		addField(comment);
		string = new ColorFieldEditor(Constants.COLOR_STRING,"�ַ�����ɫ��",getFieldEditorParent());
		addField(string);
		object = new ColorFieldEditor(Constants.COLOR_OBJECT,"���ö�����ɫ��",getFieldEditorParent());
		addField(object);
		codeFont= new FontFieldEditor(Constants.CODE_FONT,"���壺",getFieldEditorParent());
		addField(codeFont);
	}
	
}
