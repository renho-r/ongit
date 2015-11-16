package com.renho.beanfromdb.views.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.renho.beanfromdb.modal.DBViewSuperBean;

public class ViewLabelProvider extends LabelProvider {
	@Override
	public String getText(Object obj) {
		return ((DBViewSuperBean) obj).getTitle();
	}

	@Override
	public Image getImage(Object obj) {
		return null;
	}
}