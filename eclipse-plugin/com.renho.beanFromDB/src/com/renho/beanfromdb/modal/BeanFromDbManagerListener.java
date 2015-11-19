package com.renho.beanfromdb.modal;

import com.renho.beanfromdb.controller.BeanFromDbManagerEvent;

public interface BeanFromDbManagerListener {
	public void dbConfigChanged(BeanFromDbManagerEvent event);
	public void dbConfigTablesChanged(BeanFromDbManagerEvent event);
}
