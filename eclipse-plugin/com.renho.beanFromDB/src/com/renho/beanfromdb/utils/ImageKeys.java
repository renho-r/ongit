package com.renho.beanfromdb.utils;

import org.eclipse.jface.resource.ImageDescriptor;

import com.renho.beanfromdb.Activator;

public final class ImageKeys {
	public static final String IMAGE_DB = "icons/dbconfig/database.gif";
	public static final String IMAGE_TABLE = "icons/dbconfig/table.gif";
	public static final String IMG_PLUG = "icons/op/plus.png";

	public static ImageDescriptor getImageDescriptor(String path) {
		return Activator.getImageDescriptor(path);
	}
}
