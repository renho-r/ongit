package com.renho.beanfromdb.wizard.parsebean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.modal.BeanStruct;

public class DefaultParseBeanImpl extends IParseBean {

	@Override
	protected void show(List<BeanStruct> beans) {
		StringBuilder sb = new StringBuilder();
		for(BeanStruct bs:beans) {
			sb.append("    private").append(" ").append(bs.getType()).append(" ").append(bs.getName()).append("\n");
		}
		MessageDialog.openInformation(PlatformUI.getWorkbench().getDisplay().getActiveShell(),  "ÌבÊ¾", sb.toString());
	}

	@Override
	protected void transColumnName(List<BeanStruct> beans) {

	}

	@Override
	protected void transColumnType(List<BeanStruct> beans) {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/mysqltype.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		outter:
		for(BeanStruct bs:beans) {
			for(Object key:prop.keySet()) {
				if(bs.getType().matches(key.toString())) {
					String packageClass = prop.getProperty((String) key);
					int index = packageClass.lastIndexOf(".");
					String packagePath = packageClass.substring(0, index);
					String className = packageClass.substring(index + 1);
					bs.setPath(packagePath);
					bs.setType(className);
					continue outter;
				}
			}
			bs.setType("noDefined");
		}
	}

}
