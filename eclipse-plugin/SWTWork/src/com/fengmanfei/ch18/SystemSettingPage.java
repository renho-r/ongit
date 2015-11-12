package com.fengmanfei.ch18;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class SystemSettingPage extends PreferencePage {

	private Text userName;
	private Text password;
	//�÷���Ϊ����ʵ�ֵķ������ڴ˷����д���ҳ���ϵĸ��ֿؼ�
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		//��ȡ�����ҳ���PreferenceStore����
		IPreferenceStore preferenceStore = getPreferenceStore();

		new Label(composite, SWT.LEFT).setText("��¼�û���:");
		userName = new Text(composite, SWT.BORDER);
		userName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//�����û���Ϊ�������ļ��е�ֵ
		userName.setText(preferenceStore.getString(Constants.USER_NAME));

		new Label(composite, SWT.LEFT).setText("��¼����:");
		password = new Text(composite, SWT.BORDER);
		password.setEchoChar('*');
		password.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//��������Ϊ�������ļ��е�ֵ
		password.setText(preferenceStore.getString(Constants.PASSWORD));
		return composite;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performDefaults()
	 * ���Ǹ����еķ��������������ָ�Ĭ��ֵ����ťʱ���ø÷���
	 */
	protected void performDefaults() {
		IPreferenceStore preferenceStore = getPreferenceStore();
		userName.setText( preferenceStore.getDefaultString(Constants.USER_NAME));
		password.setText( preferenceStore.getDefaultString(Constants.PASSWORD));
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performOk()
	 * ���Ǹ����еķ�������������Ӧ�á���ťʱ���ø÷���
	 */
	public boolean performOk() {
		IPreferenceStore preferenceStore = getPreferenceStore();
		if (userName != null)
			preferenceStore.setValue(Constants.USER_NAME, userName.getText());
		if (password != null)
			preferenceStore.setValue(Constants.PASSWORD, password.getText());
		return true;
	}
	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#contributeButtons(org.eclipse.swt.widgets.Composite)
	 */
	protected void contributeButtons(Composite parent) {
		// super.contributeButtons(parent);
		Button bt1 = new Button(parent, SWT.NONE);
		bt1.setText("��ťһ");
		((GridLayout) parent.getLayout()).numColumns++;
		Button bt2 = new Button(parent, SWT.NONE);
		bt2.setText("��ť��");
		((GridLayout) parent.getLayout()).numColumns++;

	}

}
