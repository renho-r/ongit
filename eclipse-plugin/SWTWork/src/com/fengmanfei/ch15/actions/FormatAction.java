package com.fengmanfei.ch15.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.ch15.MainWindow;

public class FormatAction extends Action {
	public static final String TYPE_FORECOLOR = "FORECOLOR";
	public static final String TYPE_BGCOLOR = "BGCOLOR";
	public static final String TYPE_FONT = "FONT";
	private String formatType;// ͨ����ͬ�����������첻ͬ�Ĵ����¼�
	public FormatAction(String type) {
		super();
		this.formatType = type;
		initAction();
	}

	private void initAction() {
		if (formatType.equals(TYPE_FONT)) {
			this.setText("��������");
			this.setToolTipText("��������");
			setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\font.gif"));
		} else if (formatType.equals(TYPE_FORECOLOR)) {
			this.setText("����ǰ��ɫ");
			this.setToolTipText("����ǰ��ɫ");
			setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\foreColor.gif"));
		} else {
			this.setText("���ñ���ɫ");
			this.setToolTipText("���ñ���ɫ");
			setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\bgColor.gif"));
		}

	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		Text content = MainWindow.getApp().getContent();
		if (formatType.equals(TYPE_FONT)) {
			FontDialog fontDialog = new FontDialog(MainWindow.getApp().getShell());
			fontDialog.setFontList(content.getFont().getFontData());
			FontData fontData = fontDialog.open();
			if (fontData != null) {
				Font font = new Font(MainWindow.getApp().getShell().getDisplay(), fontData);
				content.setFont(font);
			}
		} else if (formatType.equals(TYPE_FORECOLOR)) {
			ColorDialog colorDialog = new ColorDialog(MainWindow.getApp().getShell());
			colorDialog.setRGB(content.getForeground().getRGB());
			RGB rgb = colorDialog.open();
			if (rgb != null) {
				Color foregroundColor = new Color(MainWindow.getApp().getShell().getDisplay(), rgb);
				content.setForeground(foregroundColor);
				foregroundColor.dispose();
			}
		} else {
			ColorDialog colorDialog = new ColorDialog(MainWindow.getApp().getShell());
			colorDialog.setRGB(content.getBackground().getRGB());
			RGB rgb = colorDialog.open();
			if (rgb != null) {
				Color bgColor = new Color(MainWindow.getApp().getShell().getDisplay(), rgb);
				content.setBackground(bgColor);
				bgColor.dispose();
			}
		}
	}
}
