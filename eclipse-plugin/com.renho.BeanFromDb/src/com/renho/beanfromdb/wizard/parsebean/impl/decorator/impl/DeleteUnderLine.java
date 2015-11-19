package com.renho.beanfromdb.wizard.parsebean.impl.decorator.impl;

import java.util.List;

import com.renho.beanfromdb.modal.ClassStruct;
import com.renho.beanfromdb.modal.FieldStruct;
import com.renho.beanfromdb.wizard.modal.ExportSetting;
import com.renho.beanfromdb.wizard.parsebean.impl.decorator.TransDecorator;

public class DeleteUnderLine extends TransDecorator {

	@Override
	public void trans(ClassStruct classStruct, ExportSetting es) {
		super.trans(classStruct, es);
		deleteUnderLine(classStruct, es);
	}

	private void deleteUnderLine(ClassStruct classStruct, ExportSetting es) {
		String tableName = classStruct.getTableName();
		String[] splitTable = tableName.split("_");
		StringBuilder sbTableName = new StringBuilder("");
		for(String s:splitTable) {
			if(null != s && !"".equals(s)) {
				sbTableName.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));				
			}
		}
		classStruct.setTableName(sbTableName.toString());
		
		List<FieldStruct> fields = classStruct.getFields();
		for(FieldStruct fs:fields) {
			String fieldName = fs.getName();
			String[] splitBy_ = fieldName.split("_");
			StringBuilder sb = new StringBuilder("");
			for(int i=0; i<splitBy_.length; i++) {
				if(!"".equals(sb.toString()) && null != splitBy_[i] && !"".equals(splitBy_[i])) {
					splitBy_[i] = splitBy_[i].substring(0, 1).toUpperCase() + splitBy_[i].substring(1);
				}
				sb.append(splitBy_[i]);
			}
			fs.setName(sb.toString());
		}
		
	}

}
