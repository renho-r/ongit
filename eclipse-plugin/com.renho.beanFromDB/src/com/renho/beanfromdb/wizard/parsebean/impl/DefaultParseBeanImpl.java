package com.renho.beanfromdb.wizard.parsebean.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import com.renho.beanfromdb.dialogs.DbConfigShowDialog;
import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.modal.MethodStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.IParseBean;

public class DefaultParseBeanImpl implements IParseBean {

	public void show(ClassStruct classStruct, ExportSetting exportSetting) {
		
		String filePath = exportSetting.getFilePath();
		String showStr = getShowStr(classStruct, exportSetting);
		if(null == filePath || "".equals(filePath)) {
			Dialog showClassDialog = new DbConfigShowDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), showStr);
			showClassDialog.open();			
		} else {
			File direFile = new File(filePath);
			if(!direFile.exists()) {
				direFile.mkdirs();
			}
			
			File javaFile = new File(filePath + File.separator + classStruct.getTableName() + ".java");
			FileWriter fw = null;
			try {
				fw = new FileWriter(javaFile);
				fw.write(showStr);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(null != fw) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private String getShowStr(ClassStruct classStruct, ExportSetting exportSetting) {
		final StringBuilder sb = new StringBuilder("");
		if(null != classStruct.getImportList() && classStruct.getImportList().size() > 0) {
			for(String importPath:classStruct.getImportList()) {
				sb.append("import ").append(importPath).append(";\r\n");
			}			
		}
		sb.append("\r\n");
		
		sb.append("public class " + classStruct.getTableName().substring(0, 1).toUpperCase() + classStruct.getTableName().substring(1) + " {\r\n");
		sb.append("\r\n");
		List<FieldStruct> fields = classStruct.getFields();
		for(FieldStruct fs:fields) {
			sb.append("\tprivate").append(" ").append(fs.getType()).append(" ").append(fs.getName()).append(";\r\n");
		}
		sb.append("\r\n");

		List<MethodStruct> methodStructs = classStruct.getMethods();
		if(null != methodStructs && methodStructs.size() > 0) {
			for(MethodStruct ms:methodStructs) {
				switch(ms.getMethodType()) {
				case MethodStruct.GETTER:
					sb.append("\tpublic ").append(ms.getBackType()).append(" ").append(ms.getMethodName()).append("() {\r\n")
					.append("\t\treturn this.").append(ms.getParamName()).append(";\r\n")
					.append("\t}\r\n");
					break;
				case MethodStruct.SETTER:
					sb.append("\tpublic ").append("void ").append(ms.getMethodName()).append("(").append(ms.getParamType()).append(" ").append(ms.getParamName()).append(") {\r\n")
					.append("\t\tthis.").append(ms.getParamName()).append(" = ").append(ms.getParamName()).append(";\r\n")
					.append("\t}\r\n");
					break;
				}
				sb.append("\r\n");
			}			
		}
		
		sb.append("}");
		return sb.toString();
	}

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		
	}
}
