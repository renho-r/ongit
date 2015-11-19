package com.renho.beanfromdb.views.provider;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.renho.beanfromdb.cache.ImageCache;
import com.renho.beanfromdb.modal.DBConfig;
import com.renho.beanfromdb.modal.DBViewSuperBean;
import com.renho.beanfromdb.modal.Table;
import com.renho.beanfromdb.utils.ImageKeys;

public class ViewLabelProvider extends LabelProvider {
	@Override
	public String getText(Object obj) {
		return ((DBViewSuperBean) obj).getTitle();
	}

	@Override
	public Image getImage(Object obj) {
		if(obj instanceof DBConfig) {
			return ImageCache.getInstance().getImage(ImageKeys.getImageDescriptor(ImageKeys.IMAGE_DB));
		} else if(obj instanceof Table) {
			return ImageCache.getInstance().getImage(ImageKeys.getImageDescriptor(ImageKeys.IMAGE_TABLE));
		}
		return null;
	}
}