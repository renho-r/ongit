package com.renho.beanfromdb.wizard;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.Activator;
import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.utils.DbUtil;
import com.renho.beanfromdb.views.BeanFromDbView;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.DefaultParseBeanImpl;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl.TransColumn;
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
		if(wizardSettings == null) {
			wizardSettings = toBeanSettings.addNewSection("ExportNewWizard");
		}
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
		} catch(InvocationTargetException e){
			e.printStackTrace();
			return false;
		}
		catch(InterruptedException e){
			return false;
		}
		return true;
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
		PreparedStatement pstsm = null;
		ResultSet rs = null;
		try {
			pstsm = conn.prepareStatement("SHOW COLUMNS FROM " + table.getTableName());
			rs = pstsm.executeQuery();
			ClassStruct cs = new ClassStruct(table.getTableName());
			List<FieldStruct> fields = new ArrayList<>();
			while(rs.next()) {
				String columnName = rs.getString(1);
				String columnType = rs.getString(2);
				FieldStruct fieldStruct = new FieldStruct(columnName, columnType);
				fields.add(fieldStruct);
			}
			cs.setFields(fields);
			IParseBean parseBean = new DefaultParseBeanImpl();
			TransDecorator transColumn = new TransColumn();
			transColumn.setParseBean(parseBean);
			TransDecorator temp = transColumn;
			try {
				for(String decorator:exportSetting.getTranBehavior()) {
					TransDecorator t;
					t = (TransDecorator) Class.forName("com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl." + decorator).newInstance();
					t.setParseBean(temp);
					temp = t;
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			temp.trans(cs, exportSetting);
			transColumn.show(cs, exportSetting);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(pstsm, rs);
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
