package com.renho.beanfromdb.actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.utils.DbUtil;
import com.renho.beanfromdb.views.BeanFromDbView;

public class OpenDbConfigAction implements IObjectActionDelegate {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	private IWorkbenchPart targetPart;
	
	public OpenDbConfigAction() {
	}

	@Override
	public void run(IAction action) {
		BeanFromDbView beanFromDbView = (BeanFromDbView)targetPart;
		DBViewSuperBean[] selected = beanFromDbView.getSelectedDbConfig();
		PreparedStatement pstsm = null;
		ResultSet rs = null;
		try {
			Connection conn = null;
			conn = DbUtil.getConnection((DBConfig) selected[0]);
			pstsm = conn.prepareStatement("show tables");
			rs = pstsm.executeQuery();
			List<DBViewSuperBean> tableList = new ArrayList<>();
			while(rs.next()) {
				String tableName = rs.getString(1);
				Table table = new Table(tableName);
				table.setParent((DBConfig)selected[0]);
				tableList.add(table);
			}
			BeanFromDbManager.getBeanFromDbManager().addDbConfigTables((DBViewSuperBean[])tableList.toArray(new DBViewSuperBean[tableList.size()]), (DBConfig)selected[0]);
			ConnectionCache.saveConn(((DBConfig)selected[0]).getTitle(), conn);
		} catch (SQLException e) {
			MessageDialog.openError(targetPart.getSite().getShell(), "errer", "打开数据库失败!");
		}finally {
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
