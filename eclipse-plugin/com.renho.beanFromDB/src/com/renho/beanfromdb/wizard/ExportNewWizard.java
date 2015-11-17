package com.renho.beanfromdb.wizard;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.Activator;
import com.renho.beanfromdb.actions.utils.Db2Java;
import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.modal.BeanStruct;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.views.BeanFromDbView;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.DefaultParseBeanImpl;
import com.renho.beanfromdb.wizard.parsebean.IParseBean;

public class ExportNewWizard extends Wizard implements INewWizard {

	private GetBeanSettingWizardPage getBeanSettingWizardPage;
	private GetBeanFilePathWizardPage getBeanFilePathWizardPage;
	
	public ExportNewWizard() {
		
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("导出向导");
		IDialogSettings toBeanSettings = Activator.getDefault().getDialogSettings();
		IDialogSettings wizardSettings = toBeanSettings.getSection("ExportNewWizard");
		if(wizardSettings == null)
			wizardSettings = toBeanSettings.addNewSection("ExportNewWizard");
		setDialogSettings(toBeanSettings);
	}

	@Override
	public boolean performFinish() {
		try{
			getContainer().run(true, true, new IRunnableWithProgress(){
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					doFinish(monitor);
				}
			});
		}
		catch(InvocationTargetException e){
			e.printStackTrace();
			return false;
		}
		catch(InterruptedException e){
			return false;
		}
		return false;
	}

	private void doFinish(IProgressMonitor monitor) {
		Display display = null;
		Shell shell = getShell();
		if (shell == null) {
			display = PlatformUI.getWorkbench().getDisplay();
		} else {
			display = shell.getDisplay();
		}
		display.asyncExec(new Runnable(){
			public void run() {
				List<String> behivorList = new ArrayList<>();
				String filePath = "";
				if(getContainer().getCurrentPage() == getBeanSettingWizardPage) {
					behivorList = getBeanSettingWizardPage.getTranBeanSetting();
				} else if(getContainer().getCurrentPage() == getBeanFilePathWizardPage) {
					behivorList = getBeanSettingWizardPage.getTranBeanSetting();
					filePath = getBeanFilePathWizardPage.getTranBeanSetting();
				}
				ExportSetting exportSetting = new ExportSetting(filePath, behivorList);
				doDone(exportSetting);
			}
			
		});
	}
	
	private void doDone(ExportSetting exportSetting) {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		BeanFromDbView beanFromDbView = (BeanFromDbView) page.getActivePart();
		DBViewSuperBean[] selected = beanFromDbView.getSelectedDbConfig();
		Table table = (Table) selected[0];
		DBViewSuperBean parent = (DBViewSuperBean) table.getParent();
		Connection conn = ConnectionCache.getConnection(parent.getTitle());
		
		try {
			PreparedStatement pstsm = conn.prepareStatement("SHOW COLUMNS FROM " + table.getTableName());
			ResultSet rs = pstsm.executeQuery();
			List<BeanStruct> list = new ArrayList<>();
			while(rs.next()) {
				String columnName = rs.getString(1);
				String columnType = rs.getString(2);
				BeanStruct beanStruct = new BeanStruct(columnName, columnType);
				list.add(beanStruct);
			}
			
			IParseBean parseBean = new DefaultParseBeanImpl();
			parseBean.parse(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPages() {
		getBeanSettingWizardPage = new GetBeanSettingWizardPage();
		addPage(getBeanSettingWizardPage);
		getBeanFilePathWizardPage = new GetBeanFilePathWizardPage();
		addPage(getBeanFilePathWizardPage);
	}

}
