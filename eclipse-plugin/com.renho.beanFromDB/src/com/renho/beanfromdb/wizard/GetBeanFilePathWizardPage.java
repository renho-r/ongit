package com.renho.beanfromdb.wizard;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GetBeanFilePathWizardPage extends WizardPage {

	private Text text;
	
	protected GetBeanFilePathWizardPage() {
		super("导出参数"); //$NON-NLS-1$
		setTitle("导出参数 title"); //$NON-NLS-1$
		setDescription("导出参数dec"); //$NON-NLS-1$
//		setImageDescriptor("导出参数img");
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		container.setLayout(gridLayout);
		//
		setControl(container);
		
		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		label.setText("请选择保存路径:");
		
		text = new Text(container, SWT.BORDER);
		final GridData gd_text = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
		gd_text.widthHint = 117;
		text.setLayoutData(gd_text);
		
		Button selectedButton = new Button(container, SWT.NONE);
		selectedButton.setText("Browse...");
		selectedButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				DirectoryDialog directoryDialog = new DirectoryDialog(container.getShell());
				directoryDialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().toString());
				String filePath = directoryDialog.open();
				if(null != text && !"".equals(text)) {
					text.setText(filePath);					
				}
			}
		});
		
		setPageComplete(true);
		setMessage(null);
		setErrorMessage(null);
	}
	
	public String getTranBeanSetting() {
		return text.getText();
	}

}
