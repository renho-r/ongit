package com.fengmanfei.ch17;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class Email extends WizardPage {

	private Text email;

	protected Email() {
		super(BookSurveyWizard.EMAIL, "���������ĵ����ʼ�:", ImageDescriptor.createFromFile(QuestionOne.class, "q.gif"));
		this.setMessage("����������E-mail��");
		//��ʼ״̬ʱ����ҳ��δ��ɣ�����һ������ť��Ϊ������
		this.setPageComplete(false);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		new Label(composite, SWT.LEFT).setText("Email:");
		email = new Text(composite, SWT.BORDER);
		email.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		//Ϊ�����ʼ��ļ���ע���¼�
		email.addVerifyListener(new VerifyListener() {
			//���ı����ַ��ı�ʱ
			public void verifyText(VerifyEvent e) {
				//�����ʱ����email�ĸ�ʽ
				if (email.getText().indexOf('@') > -1) {
					//���ô�����ϢΪnull
					setErrorMessage(null);
					//����ҳ�����,����һ������ť�ÿ���
					setPageComplete(true);
				} else
					//���������email��ʽ������ʾ������Ϣ
					setErrorMessage("��������Ч��Email!");
			}
		});
		setControl(composite);
	}
}
