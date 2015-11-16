package com.renho.beanfromdb.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.controller.BeanFromDbManager;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.views.BeanFromDbView;

public class OpenDbConfigAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public OpenDbConfigAction() {
		System.out.println(111111111);
	}

	@Override
	public void run(IAction action) {
		BeanFromDbView beanFromDbView = (BeanFromDbView)targetPart;
		DBViewSuperBean[] selected = beanFromDbView.getSelectedDbConfig();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = ((DBConfig)selected[0]).getUrl() + "?user=" + ((DBConfig)selected[0]).getUser() + "&password=" + ((DBConfig)selected[0]).getPassword();
			Connection conn = null;
			conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement("show tables");
			ResultSet rs = pstmt.executeQuery();
			List<DBViewSuperBean> tableList = new ArrayList<>();
			while(rs.next()) {
				String tableName = rs.getString(1);
				Table table = new Table(tableName);
				table.setParent((DBConfig)selected[0]);
				tableList.add(table);
			}
			//((DBConfig)selected[0]).setChildren(tableList);
			BeanFromDbManager.getBeanFromDbManager().addDbConfigTables((DBViewSuperBean[])tableList.toArray(new DBViewSuperBean[tableList.size()]), (DBConfig)selected[0]);
			ConnectionCache.saveConn(((DBConfig)selected[0]).getTitle(), conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println(333);
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;
	}
}
