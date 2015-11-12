package com.fengmanfei.myrcp.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import myRCP.MyRCPPlugin;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		//��øò���������ѡ������
		IPreferenceStore store = MyRCPPlugin.getDefault().getPreferenceStore();
		//����Ĭ�ϵ�һЩ��ѡ��ֵ
		store.setDefault(PreferenceConstants.P_BOOLEAN, true);
		store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
		store.setDefault(PreferenceConstants.P_STRING,"Default value");
	}

}
