package com.fengmanfei.myrcp.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import myRCP.MyRCPPlugin;

public class SamplePreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	public SamplePreferencePage() {
		super(GRID);
		//������ѡ������
		setPreferenceStore(MyRCPPlugin.getDefault().getPreferenceStore());
		setDescription("A demonstration of a preference page implementation");
	}
	//�����ֶα༭��
	public void createFieldEditors() {
		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH,
				"&Directory preference:", getFieldEditorParent()));
		addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN,
				"&An example of a boolean preference", getFieldEditorParent()));
		addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE,
				"An example of a multiple-choice preference", 1,
				new String[][] { { "&Choice 1", "choice1" },
						{ "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.P_STRING,
				"A &text preference:", getFieldEditorParent()));
	}
	//IWorkbenchPreferencePage �еķ�������ʱ��ʵ��
	public void init(IWorkbench workbench) {
	}

}