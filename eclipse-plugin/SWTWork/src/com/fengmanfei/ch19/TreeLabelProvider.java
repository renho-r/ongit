package com.fengmanfei.ch19;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.fengmanfei.util.ImageFactory;

public class TreeLabelProvider implements ILabelProvider{

	public Image getImage(Object element) {
		if ( element instanceof ProductEO)
			return ImageFactory.loadImage( Display.getCurrent(), ImageFactory.TOPIC);
		else if  ( element instanceof CategoryEO)
			return ImageFactory.loadImage( Display.getCurrent(), ImageFactory.TOC_CLOSED);
		return null;
	}
	//��ʾ���ڵ������
	public String getText(Object element) {
		return ((TreeElement)element).getName();
	}
	public void addListener(ILabelProviderListener listener) {
		
	}
	public void dispose() {
		ImageFactory.dispose();
		
	}
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		
	}


}
