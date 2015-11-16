package com.renho.beanfromdb.actions;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.renho.beanfromdb.actions.utils.Db2Java;
import com.renho.beanfromdb.cache.ConnectionCache;
import com.renho.beanfromdb.modal.BeanStruct;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.views.BeanFromDbView;

public class GetBeanAction implements IObjectActionDelegate {

	private IWorkbenchPart targetPart;
	
	public GetBeanAction() {
	}

	@Override
	public void run(IAction action) {
		BeanFromDbView beanFromDbView = (BeanFromDbView)targetPart;
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
			
			Properties prop = new Properties();
			InputStream in = getClass().getResourceAsStream("/mysqltype.properties");
			try {
				prop.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Db2Java db2Java = new Db2Java(list);
			db2Java.tran();
			StringBuilder sb = new StringBuilder();
			for(BeanStruct bs:list) {
				sb.append("    private").append(" ").append(bs.getType()).append(" ").append(bs.getName()).append("\n");
			}
			MessageDialog.openInformation(targetPart.getSite().getShell(),  "ÌבÊ¾", sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
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
