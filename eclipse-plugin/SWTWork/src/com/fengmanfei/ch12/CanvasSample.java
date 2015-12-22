package com.fengmanfei.ch12;

import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;

public class CanvasSample {
	private Image image = null;
	private Shell shell = null;
	private Canvas canvas = null;
	public CanvasSample() {
		createContent();
	}
	public void createContent() {
		shell = new Shell();
		shell.setLayout(new FillLayout());
		// ����һ��ͼ�����
		image = new Image(shell.getDisplay(), getClass().getResourceAsStream("eclipse48.gif"));
		// ����һ����������
		canvas = new Canvas(shell, SWT.NONE);
		// ע�ử���Ļ�ͼ�¼�
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
			// �ڻ�������ʾͼ��ͼ���ڻ����е������Ǿ����10�����أ����ϱ�10������
				e.gc.drawImage(image, 10, 10);
			}
		});
		shell.setSize(200, 150);
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Shell getShell() {
		return shell;
	}
	public void setShell(Shell shell) {
		this.shell = shell;
	}
	public static void main(String[] args) {
		Display display = Display.getDefault();
		CanvasSample cSample = new CanvasSample();
		cSample.getShell().open();
		while (!cSample.getShell().isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		cSample.getImage().dispose();
		display.dispose();
	}

}
