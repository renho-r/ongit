package com.renho.beanfromdb.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.utils.TestConnectUtil;

public class DbConfigDialog extends Dialog {

	private Text nameText;
	private Text descriptionText;
	private Text urlText;
	private Text userText;
	private Text passwordText;
	
	@Override
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
        container.setLayout(gridLayout);
        
        final Label nameLabel = new Label(container, SWT.NONE);
        nameLabel.setText("name:");
        nameLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
        nameText = new Text(container, SWT.BORDER);
        nameText.setBounds(10, 20, 300, 30);
        nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
        nameText.setText("mytest");
        
        final Label descriptionLabel = new Label(container, SWT.NONE);
        descriptionLabel.setText("description:");
        descriptionLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
        descriptionText = new Text(container, SWT.BORDER);
        descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        final Label urlLabel = new Label(container, SWT.NONE);
        urlLabel.setText("url:");
        urlLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
        urlText = new Text(container, SWT.BORDER);
        urlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        urlText.setText("jdbc:mysql://localhost:3306/test");
        
        final Label userLabel = new Label(container, SWT.NONE);
        userLabel.setText("user:");
        userLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
        userText = new Text(container, SWT.BORDER);
        userText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        userText.setText("root");
        
        final Label passwordLabel = new Label(container, SWT.NONE);
        passwordLabel.setText("password:");
        passwordLabel.setLayoutData(new GridData(GridData.END, GridData.CENTER, false, false));
        passwordText = new Text(container, SWT.BORDER);
        passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        passwordText.setText("root123");
        
        return container;
	}

	public DbConfigDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
	}

	@Override
	protected Point getInitialSize() {
		return new Point(400,400);
	}

	@Override
	protected void initializeBounds() {
		super.createButton((Composite) this.getButtonBar(), 999, "test", true);
		super.createButton((Composite) this.getButtonBar(), IDialogConstants.OK_ID, "确定", false);
		super.createButton((Composite) this.getButtonBar(), IDialogConstants.CANCEL_ID, "取消", false);
		super.initializeBounds();
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		return null;
	}
	@Override
	protected void configureShell(Shell newShell){
		super.configureShell(newShell);
		newShell.setText("create db config");
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		DBConfig dbConfig = null;
		if(999 == buttonId) {
			String nameTextValue = nameText.getText();
			if(!checkNull(nameTextValue)) {
				MessageDialog.openWarning(this.getShell(), "提示", "name不能为空!");
				return;
			}
			if(!BeanFromDbManager.getBeanFromDbManager().checkOnlyDbName(nameTextValue)) {
				MessageDialog.openWarning(this.getShell(), "提示", "当前name已经存在!");
				return;
			}
			String descriptionTextValue = descriptionText.getText();
			String urlTextValue = urlText.getText();
			if(!checkNull(urlTextValue)) {
				MessageDialog.openWarning(this.getShell(), "提示", "url不能为空!");
				return;
			}
			String userTextValue = userText.getText();
			if(!checkNull(userTextValue)) {
				MessageDialog.openWarning(this.getShell(), "提示", "user不能为空!");
				return;
			}
			String passwordTextValue = passwordText.getText();
			if(!checkNull(passwordTextValue)) {
				MessageDialog.openWarning(this.getShell(), "提示", "password不能为空!");
				return;
			}
			dbConfig = new DBConfig(nameTextValue, descriptionTextValue, urlTextValue, userTextValue, passwordTextValue);
			if(TestConnectUtil.testConnect(dbConfig)) {
				MessageDialog.openInformation(this.getShell(),  "提示", "Connect Success" );
			} else {
				MessageDialog.openError(this.getShell(),  "提示", "Connect fail" );
			}
		} else {
			if(0 == buttonId) {
				String nameTextValue = nameText.getText();
				if(!checkNull(nameTextValue)) {
					MessageDialog.openWarning(this.getShell(), "提示", "name不能为空!");
					return;
				}
				if(!BeanFromDbManager.getBeanFromDbManager().checkOnlyDbName(nameTextValue)) {
					MessageDialog.openWarning(this.getShell(), "提示", "当前name已经存在!");
					return;
				}
				String descriptionTextValue = descriptionText.getText();
				String urlTextValue = urlText.getText();
				if(!checkNull(urlTextValue)) {
					MessageDialog.openWarning(this.getShell(), "提示", "url不能为空!");
					return;
				}
				String userTextValue = userText.getText();
				if(!checkNull(userTextValue)) {
					MessageDialog.openWarning(this.getShell(), "提示", "user不能为空!");
					return;
				}
				String passwordTextValue = passwordText.getText();
				if(!checkNull(passwordTextValue)) {
					MessageDialog.openWarning(this.getShell(), "提示", "password不能为空!");
					return;
				}
				dbConfig = new DBConfig(nameTextValue, descriptionTextValue, urlTextValue, userTextValue, passwordTextValue);
				dbConfig.setTitle(nameTextValue);
				BeanFromDbManager.getBeanFromDbManager().addDbConfig(new DBConfig[]{dbConfig});
			}
			super.buttonPressed(buttonId);			
		}
	}

	private boolean checkNull(String value) {
		if(null != value && !"".equals(value)) {
			return true;
		}else {
			return false;
		}
	}
}
