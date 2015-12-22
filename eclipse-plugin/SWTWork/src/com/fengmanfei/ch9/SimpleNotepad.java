package com.fengmanfei.ch9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.LineBackgroundEvent;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.fengmanfei.util.ImageFactory;

public class SimpleNotepad {

	private Shell sShell = null;
	private ViewForm viewForm = null;
	private ToolBar toolBar = null;
	private Composite composite = null;
	private StyledText styledText = null;
	private void createViewForm() {
		viewForm = new ViewForm(sShell, SWT.NONE);
		createToolBar();
		viewForm.setTopLeft(toolBar);
		createComposite();
		viewForm.setContent(composite);
	}

	private void createToolBar() {
		//�����������͹�������ť
		toolBar = new ToolBar(viewForm, SWT.FLAT);
		final ToolItem boldButton = new ToolItem(toolBar, SWT.PUSH);
		boldButton.setImage( ImageFactory.loadImage(toolBar.getDisplay(),ImageFactory.BOLD));
		final ToolItem italicButton = new ToolItem(toolBar, SWT.PUSH);
		italicButton.setImage( ImageFactory.loadImage(toolBar.getDisplay(),ImageFactory.ITALIC));
		final ToolItem underlineButton = new ToolItem(toolBar, SWT.PUSH);
		underlineButton.setImage( ImageFactory.loadImage(toolBar.getDisplay(),ImageFactory.UNDERLIN));
		
		new ToolItem(toolBar, SWT.SEPARATOR);
		final ToolItem bgColorButton = new ToolItem(toolBar, SWT.PUSH);
		bgColorButton.setImage( ImageFactory.loadImage(toolBar.getDisplay(),ImageFactory.BGCOLOR));
		final ToolItem forColorButton = new ToolItem(toolBar, SWT.PUSH);
		forColorButton.setImage( ImageFactory.loadImage(toolBar.getDisplay(),ImageFactory.FORCOLOR));
		//������ť�¼��������
		Listener listener = new Listener(){
			public void handleEvent(Event event) {
				//�����ǰδѡ���ı����أ��������κ��¼�
				if (styledText.getSelectionCount()==0)
					return;
				System.out.println(styledText.getSelection().toString());
				System.out.println(styledText.getSelectionRange().toString());
				//����һ��StyleRange����
				StyleRange styleRange=null;
				//��õ�ǰ��ѡ���ı����ڵĿ�ʼλ�úͳ���
				Point select = styledText.getSelectionRange();
				//����Ҫ����һ�µ�ǰ��ѡ���ı����Ƿ��Ѿ������ù���StyleRange����
				StyleRange[] ranges = styledText.getStyleRanges( select.x,select.y);
				//����ҵ��ˣ��򽫸�ѡ���ַ����ĵ�һ��StyleRange��ʽ��Ϊ��ǰ����Ҫ�ı����ʽ
				//���򴴽�һ������ʽ
				if( ranges.length>0)
					styleRange=ranges[0];
				else 
					styleRange = new StyleRange();
				//������ʽ�������õ�λ��Ϊѡ���ı���λ��
				styleRange.start=select.x;
				styleRange.length=select.y;
				//���������Ϊ�Ӵְ�ť����Ҫ����������ʽΪSWT.BOLD
				if (event.widget==boldButton)
					styleRange.fontStyle=styleRange.fontStyle|SWT.BOLD;
				//���������Ϊ��б��ť����Ҫ����������ʽΪSWT.ITALIC
				else if (event.widget==italicButton)
					styleRange.fontStyle=styleRange.fontStyle|SWT.ITALIC;
				//���������Ϊ���»��߰�ť����Ҫ����underline����Ϊtrue
				else if (event.widget==underlineButton)
					styleRange.underline=true;
				//���������Ϊ���ñ���ɫ��ť����Ҫ����background����
				else if (event.widget==bgColorButton){
					ColorDialog dialog = new ColorDialog(sShell);
					RGB rgb = dialog.open();
					if ( rgb != null ){
						Color  color = new Color( sShell.getDisplay() , rgb );
						styleRange.background=color;
					}
				}
				//���������Ϊ����ǰ��ɫ��ť����Ҫ����foreground����
				else if (event.widget==forColorButton){
					ColorDialog dialog = new ColorDialog(sShell);
					RGB rgb = dialog.open();
					if ( rgb != null ){
						Color  color = new Color( sShell.getDisplay() , rgb );
						styleRange.foreground=color;
					}
				}
				//����µ���ʽӦ�����ı�
				styledText.setStyleRange( styleRange );
			}
			
		};
		//Ϊ������ťע��ѡ���¼�
		boldButton.addListener( SWT.Selection, listener);
		italicButton.addListener( SWT.Selection, listener);
		underlineButton.addListener( SWT.Selection, listener);
		bgColorButton.addListener( SWT.Selection, listener);
		forColorButton.addListener( SWT.Selection, listener);
	}

	private void createComposite() {
		composite = new Composite(viewForm, SWT.NONE);
		composite.setLayout(new FillLayout());
		styledText = new StyledText(composite, SWT.NONE);
		
		/*
		styledText.addVerifyListener( new VerifyListener(){
			public void verifyText(VerifyEvent e) {
				//System.out.println(e.toString());
				if (e.end - e.start == 0) {
					if (e.text.equals("class")) {
						e.text = "class";
					}
				}
				
			}
			
		});
		/*
		styledText.addModifyListener( new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				System.out.print(e.toString());
			}
			
		});
		*/
		//ע��ExtendedModify�¼�
		styledText.addExtendedModifyListener( new ExtendedModifyListener(){
			public void modifyText(ExtendedModifyEvent event) {
				//����޸��ַ�������λ��
		        int end = event.start + event.length - 1;
		        //���Ϊ�����ַ�����
		        if (event.start <= end) {
		        	//��ò�����ַ�StyleRange����
		        	String text = styledText.getText(event.start, end);
		        	//����һ��list���󱣴����е�
		        	java.util.List ranges = new java.util.ArrayList();
		        	//ѭ�������ÿһ���ַ���������ַ�Ϊ���֣��򽫸��ַ���λ�ñ��浽һ��StyleRange������
		        	for (int i = 0; i < text.length(); i++) {
		        		if ("0123456789".indexOf(text.charAt(i)) > -1) 
		        			ranges.add(new StyleRange(event.start + i, 1, event.display.getSystemColor( SWT.COLOR_RED), null, SWT.BOLD));
		        	}
		        	//�������StyleRange�����list��Ϊ�գ���list�е�StyleRangeӦ�õ���ʽ���ı���
		        	if (!ranges.isEmpty()) 
		        		styledText.replaceStyleRanges(event.start, event.length, (StyleRange[]) ranges.toArray(new StyleRange[0]));
		        }
		   }	
		});
		//ע�ᱳ��ɫ�ı��¼�
	    styledText.addLineBackgroundListener(new LineBackgroundListener() {
	        public void lineGetBackground(LineBackgroundEvent event) {
	        	//��õ�ǰ�е��ı�
	        	String text = event.lineText;
	        	//������ı����ҵ�import�ؼ��֣������ø��еı���ɫΪ��ɫ
	        	if ( text.indexOf("import")>-1)
	            event.lineBackground = styledText.getDisplay().getSystemColor(SWT.COLOR_GRAY);
	        }
	    });
	}

	public static void main(String[] args) {

		Display display = Display.getDefault();
		SimpleNotepad thisClass = new SimpleNotepad();
		thisClass.createSShell();
		thisClass.sShell.open();

		while (!thisClass.sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		ImageFactory.dispose();
		display.dispose();
	}

	private void createSShell() {
		sShell = new Shell();
		sShell.setText("Simple Notepad");
		sShell.setLayout(new FillLayout());
		createViewForm();
		sShell.setSize(new Point(300, 200));
	}

}
