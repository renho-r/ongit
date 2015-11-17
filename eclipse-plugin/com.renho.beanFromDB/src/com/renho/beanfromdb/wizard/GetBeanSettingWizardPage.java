package com.renho.beanfromdb.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class GetBeanSettingWizardPage extends WizardPage {

	private Composite container;
	private Button delUnderLineCheckButton;
	private Button addImportCheckButton;
	private Button addGeterOrSetterCheckButton;
	
	protected GetBeanSettingWizardPage() {
		super("导出配置"); //$NON-NLS-1$
		setTitle("导出配置"); //$NON-NLS-1$
//		setDescription("导出参数dec"); //$NON-NLS-1$
//		setImageDescriptor("导出参数img");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		container.setLayout(gridLayout);
		//
		setControl(container);
		
		delUnderLineCheckButton = new Button(container, SWT.CHECK);
		delUnderLineCheckButton.setText("去除下划线");
		delUnderLineCheckButton.setBounds(20, 45, 150, 20);
		delUnderLineCheckButton.setData("DeleteUnderLine");
		
		addImportCheckButton = new Button(container, SWT.CHECK);
		addImportCheckButton.setText("生成import");
		addImportCheckButton.setBounds(20, 45, 150, 20);
		addImportCheckButton.setData("AddImport");
		
		addGeterOrSetterCheckButton = new Button(container, SWT.CHECK);
		addGeterOrSetterCheckButton.setText("生成getter/setter");
		addGeterOrSetterCheckButton.setBounds(20, 45, 150, 20);
		addGeterOrSetterCheckButton.setData("AddGeterOrSetter");
		
		setPageComplete(true);
		setMessage(null);
		setErrorMessage(null);
	}
	
	public List<String> getTranBeanSetting() {
		List<String> tranList = new ArrayList<>();
		Control[] childrens = container.getChildren();
		for(Control c:childrens) {
			Button temp = (Button)c;
			if(temp.getSelection()) {
				tranList.add(temp.getData().toString());
			}
		}
		return tranList;
	}

}
