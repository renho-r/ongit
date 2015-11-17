package com.renho.beanfromdb.wizard.modal;

import java.util.List;

public class ExportSetting {

	private String filePath;
	private List<String> tranBehavior;
	
	public ExportSetting() {
		
	}
	
	public ExportSetting(String filePath, List<String> tranBehavior) {
		super();
		this.filePath = filePath;
		this.tranBehavior = tranBehavior;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getTranBehavior() {
		return tranBehavior;
	}

	public void setTranBehavior(List<String> tranBehavior) {
		this.tranBehavior = tranBehavior;
	}
	
	
}
