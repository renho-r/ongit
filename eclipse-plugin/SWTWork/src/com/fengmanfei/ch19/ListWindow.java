package com.fengmanfei.ch19;

import java.io.File;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.fengmanfei.util.ImageFactory;

public class ListWindow extends ApplicationWindow {

	public ListWindow() {
		super(null);
	}

	protected Control createContents(Composite parent) {
		ListViewer list = new ListViewer(parent);
		list.setContentProvider(new IStructuredContentProvider() {

			public void dispose() {
				// TODO �Զ����ɷ������

			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO �Զ����ɷ������

			}

			public Object[] getElements(Object inputElement) {
				return ((File) inputElement).listFiles();
			}

		});
		list.setLabelProvider(new ILabelProvider() {

			public Image getImage(Object element) {
				File file = (File) element;
				if (file.isDirectory())
					return ImageFactory.loadImage(Display.getCurrent(),
							ImageFactory.FOLDER);
				else
					return ImageFactory.loadImage(Display.getCurrent(),
							ImageFactory.FILE);
			}

			public String getText(Object element) {
				return ((File) element).getName();
			}

			public void addListener(ILabelProviderListener listener) {
				// TODO �Զ����ɷ������

			}

			public void dispose() {
				// TODO �Զ����ɷ������

			}

			public boolean isLabelProperty(Object element, String property) {
				// TODO �Զ����ɷ������
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
				// TODO �Զ����ɷ������

			}

		});
		list.setInput( new File("F:\\"));
		return parent;
	}

	public static void main(String[] args) {
		ListWindow test = new ListWindow();
		test.setBlockOnOpen(true);
		test.open();
		Display.getCurrent().dispose();

	}

}
