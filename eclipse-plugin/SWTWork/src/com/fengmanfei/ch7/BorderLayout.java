package com.fengmanfei.ch7;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

public class BorderLayout extends Layout {

	private Control north;

	private Control south;

	private Control east;

	private Control west;

	private Control center;

	protected Point computeSize(Composite composite, int wHint, int hHint,
			boolean flushCache) {
		getControls(composite);
		// �������Ŀ�͸�
		int width = 0, height = 0;
		// �������Ŀ��
		width += west == null ? 0 : getSize(west, flushCache).x;
		width += east == null ? 0 : getSize(east, flushCache).x;
		width += center == null ? 0 : getSize(center, flushCache).x;
		// ����ϲ����²��пؼ������ȡ�ϴ��ֵ
		if (north != null) {
			Point pt = getSize(north, flushCache);
			width = Math.max(width, pt.x);
		}
		if (south != null) {
			Point pt = getSize(south, flushCache);
			width = Math.max(width, pt.x);
		}

		// �������ĸ߶�
		height += north == null ? 0 : getSize(north, flushCache).y;
		height += south == null ? 0 : getSize(south, flushCache).y;

		int heightOther = center == null ? 0 : getSize(center, flushCache).y;
		if (west != null) {
			Point pt = getSize(west, flushCache);
			heightOther = Math.max(heightOther, pt.y);
		}
		if (east != null) {
			Point pt = getSize(east, flushCache);
			heightOther = Math.max(heightOther, pt.y);
		}
		height += heightOther;

		// ����Ŀ�͸���Ĭ�ϵĿ�͸����Ƚϣ�����֮�нϴ��
		return new Point(Math.max(width, wHint), Math.max(height, hHint));
	}

	protected void layout(Composite composite, boolean flushCache) {
		getControls(composite);
		// ��õ�ǰ������ʾ������
		Rectangle rect = composite.getClientArea();
		int left = rect.x, right = rect.width, top = rect.y, bottom = rect.height;
		// �������ؼ����õ�����
		if (north != null) {
			Point pt = getSize(north, flushCache);
			north.setBounds(left, top, rect.width, pt.y);
			top += pt.y;
		}
		if (south != null) {
			Point pt = getSize(south, flushCache);
			south.setBounds(left, rect.height - pt.y, rect.width, pt.y);
			bottom -= pt.y;
		}
		if (east != null) {
			Point pt = getSize(east, flushCache);
			east.setBounds(rect.width - pt.x, top, pt.x, (bottom - top));
			right -= pt.x;
		}
		if (west != null) {
			Point pt = getSize(west, flushCache);
			west.setBounds(left, top, pt.x, (bottom - top));
			left += pt.x;
		}
		if (center != null) {
			center.setBounds(left, top, (right - left), (bottom - top));
		}
	}

	// ����ĳһ�ؼ���ǰ�Ĵ�С�����Ϳ�
	protected Point getSize(Control control, boolean flushCache) {
		return control.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
	}

	// ���ø�����ÿ��λ�ÿؼ�������
	protected void getControls(Composite composite) {
		// ��õ�ǰ��������еĿؼ�����
		Control[] children = composite.getChildren();
		// ѭ�����пؼ�������ÿ���ؼ����ŵ�λ�öԺ�����
		for (int i = 0, n = children.length; i < n; i++) {
			Control child = children[i];
			BorderData borderData = (BorderData) child.getLayoutData();
			if (borderData.region == SWT.TOP)
				north = child;
			else if (borderData.region == SWT.BOTTOM)
				south = child;
			else if (borderData.region == SWT.RIGHT)
				east = child;
			else if (borderData.region == SWT.LEFT)
				west = child;
			else
				center = child;
		}
	}

}
