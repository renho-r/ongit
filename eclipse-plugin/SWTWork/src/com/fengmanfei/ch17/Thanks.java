package com.fengmanfei.ch17;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Thanks extends WizardPage {

	protected Thanks() {
		super(BookSurveyWizard.THANKS, "��л:", ImageDescriptor.createFromFile(QuestionOne.class, "q.gif"));
		this.setMessage("�ǳ���л���μӱ��ε��飡");
	}
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		new Label(composite, SWT.CENTER).setText("��л����֧��");
		setControl(composite);
	}

}
