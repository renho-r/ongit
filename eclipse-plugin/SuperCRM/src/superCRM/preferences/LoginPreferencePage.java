package superCRM.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import superCRM.SuperCRMPlugin;

public class LoginPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	/** �Ƿ��Զ���¼��ť */
	private Button bAutoLogin;

	/** �û��� */
	private Text userName;

	/** ���� */
	private Text password;

	public LoginPreferencePage() {
		super("��¼����");
		setPreferenceStore(SuperCRMPlugin.getDefault().getPreferenceStore());
	}

	protected Control createContents(Composite parent) {
		/** ������岼�� */
		Composite composite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gridData);
		composite.setLayout(new GridLayout(2, false));
		/** �Ƿ��¼��ť */
		bAutoLogin = new Button(composite, SWT.CHECK);
		bAutoLogin.setText("�Ƿ��Զ���¼");
		/** ������ѡ�����õ�¼��ť״̬ */
		bAutoLogin.setSelection(getPreferenceStore().getBoolean(PreferenceConstants.P_AUTO_LOGIN));
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		bAutoLogin.setLayoutData(gridData);
		/** ע���¼��ťѡ���¼������� */
		bAutoLogin.addSelectionListener(new SelectionAdapter() {
			/** ��ѡ���Ƿ��¼��ťʱ */
			public void widgetSelected(SelectionEvent e) {
				/** ���ݵ�¼״̬�����û����������Ŀ���״̬ */
				setLoginEnabled(bAutoLogin.getSelection());
			}
		});
		/** �û��� */
		new Label(composite, SWT.NONE).setText("��¼���û�����");
		userName = new Text(composite, SWT.BORDER);
		userName.setText(getPreferenceStore().getString(PreferenceConstants.P_USER_NAME));
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		userName.setLayoutData(gridData);
		/** ���� */
		new Label(composite, SWT.NONE).setText("��¼�����룺");
		password = new Text(composite, SWT.BORDER);
		password.setEchoChar('*');
		password.setText(getPreferenceStore().getString(PreferenceConstants.P_PASSWORD));
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		password.setLayoutData(gridData);
		/** ���ݵ�¼״̬�����û����������Ŀ���״̬ */
		setLoginEnabled(bAutoLogin.getSelection());
		return composite;
	}

	public void init(IWorkbench workbench) {

	}

	/** �����û����������ı���״̬ */
	private void setLoginEnabled(boolean enable) {
		userName.setEnabled(!enable);
		password.setEnabled(!enable);
	}

	/** ����ȷ����ťʱ,������ѡ���ֵ */
	public boolean performOk() {
		IPreferenceStore store = getPreferenceStore();
		store.setValue(PreferenceConstants.P_AUTO_LOGIN, bAutoLogin.getSelection());
		store.setValue(PreferenceConstants.P_USER_NAME, userName.getText());
		store.setValue(PreferenceConstants.P_PASSWORD, password.getText());
		return true;
	}

	/** �����ָ�Ĭ�ϰ�ťʱ,�ָ�Ĭ��ֵ */
	protected void performDefaults() {
		IPreferenceStore store = getPreferenceStore();
		bAutoLogin.setSelection(store.getDefaultBoolean(PreferenceConstants.P_AUTO_LOGIN));
		userName.setText(store.getDefaultString(PreferenceConstants.P_USER_NAME));
		password.setText(store.getDefaultString(PreferenceConstants.P_PASSWORD));
		setLoginEnabled(bAutoLogin.getSelection());
	}

}
