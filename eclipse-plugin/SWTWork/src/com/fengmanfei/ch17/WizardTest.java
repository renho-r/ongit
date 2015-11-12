package com.fengmanfei.ch17;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class WizardTest extends ApplicationWindow{

	public WizardTest() {
		super(null);
	}
	protected Control createContents(Composite parent) {
		parent.setLayout( new RowLayout(SWT.VERTICAL));
		Button button = new Button( parent ,SWT.NONE);
		button.setText("�򿪼��򵼶Ի���");
		button.addSelectionListener( new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				//���øöԻ���
				WizardDialog dlg = new WizardDialog(Display.getCurrent().getActiveShell(), new BookSurveyWizard());
				dlg.addPageChangedListener( new IPageChangedListener(){
					public void pageChanged(PageChangedEvent event) {				
						IWizardPage page = (IWizardPage) event.getSelectedPage();
						//���Ա���DialogSettings��һЩ����
					}
				});
				dlg.open();
			}
		});
		return parent;
	}

	public static void main(String[] args) {
		WizardTest test = new WizardTest();
		test.setBlockOnOpen( true );
		test.open();
		Display.getCurrent().dispose();
	}

}
