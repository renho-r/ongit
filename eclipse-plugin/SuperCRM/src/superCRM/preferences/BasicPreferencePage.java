package superCRM.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import superCRM.SuperCRMPlugin;

public class BasicPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public BasicPreferencePage() {
		super(GRID);
		/** ������ѡ������ */
		setPreferenceStore(SuperCRMPlugin.getDefault().getPreferenceStore());
		/** ������ѡ��ҳ��������Ϣ */
		setDescription("��������");
	}

	public void createFieldEditors() {
		/** ���һ����ѡ��ť���ֶ� */
		addField(new RadioGroupFieldEditor(PreferenceConstants.P_DEFAULT_SEARCH, "Ĭ�ϵ���������", 2, new String[][] { { "�ͻ�", "Customer" }, { "��ϵ��", "Contact" } }, getFieldEditorParent(), true));
	}

	public void init(IWorkbench workbench) {
	}

}