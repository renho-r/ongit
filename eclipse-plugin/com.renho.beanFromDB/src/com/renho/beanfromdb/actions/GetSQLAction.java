package com.renho.beanfromdb.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.dialogs.DbConfigShowDialog;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.utils.DbUtil;
import com.renho.beanfromdb.views.BeanFromDbView;

public class GetSQLAction implements IObjectActionDelegate {

	@SuppressWarnings("unused")
	private IWorkbenchPart targetPart;
	
	public GetSQLAction() {
	}

	@Override
	public void run(IAction action) {
		
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
			StringBuilder sb = new StringBuilder("SELECT ");
			while(rs.next()) {
				sb.append(rs.getString(1).toUpperCase()).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append(" FROM ").append(table.getTableName().toUpperCase());
			Dialog showClassDialog = new DbConfigShowDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), sb.toString());
			showClassDialog.open();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(pstsm, rs);
		}
		
	}
	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}

}
