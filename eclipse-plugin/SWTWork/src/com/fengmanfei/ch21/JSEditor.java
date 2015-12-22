package com.fengmanfei.ch21;

import org.eclipse.jface.action.*;
import org.eclipse.jface.preference.*;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.source.*;
import org.eclipse.jface.util.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import com.fengmanfei.ch21.action.*;


public class JSEditor extends ApplicationWindow implements IPropertyChangeListener {

	private PersistentDocument document;//�����ĵ�����
	private SourceViewer viewer;//��ʾ�ı��ؼ�����
	private EventManager eventManager;//�¼�������
	private PreferenceStore preference;//������ѡ�����õĶ���
	private IUndoManager undoManager;//�������ظ�������
	private JSEditorConfiguration configuration;//�ı��ؼ������ö���
	public JSEditor() {
		super(null);
		eventManager = new EventManager(this);//��ʼ���¼�������
	    this.addMenuBar();//��Ӳ˵�
	    this.addToolBar( SWT.FLAT );//��ӹ�����
	}
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("JavaScript �༭��");
		shell.setSize(600, 400);
	}
	protected Control createContents(Composite parent) {
		Composite top = new Composite(parent,SWT.NONE);
		top.setLayout( new FillLayout());
		//��ʼ���ĵ�����
		document = new PersistentDocument();
		//��ʼ��Դ�ļ���ʾ�ؼ�����
	    viewer = new SourceViewer(top, new VerticalRuler(10), SWT.V_SCROLL | SWT.H_SCROLL);
		//��ʼ���ĵ������ö���
	    configuration = new JSEditorConfiguration(this);
	    viewer.configure(configuration );//�����ĵ�����
	    viewer.setDocument(document);//�����ĵ�
	    undoManager = new DefaultUndoManager(100);//��ʼ����������������Ĭ�Ͽɳ���100��
	    undoManager.connect(viewer);//���ó���������Ӧ�����ĵ�
	    //��ʼ�������е�����
	    initCodeFont();
	    return parent;
	}
	//��ʼ�����������
	private void initCodeFont() {
		//����һ��Ĭ�ϵ�����
		FontData defaultFont = new FontData("Courier New",10,SWT.NORMAL);
		//�������ѡ��������������쳣����ʹ��Ĭ�ϵ�����
	    FontData data= StringConverter.asFontData(ResourceManager.getPreferenceStore().getString(Constants.CODE_FONT),defaultFont );
	    //��������
	    Font font = new Font( this.getShell().getDisplay() , data);
	    viewer.getTextWidget().setFont( font );//��������
	}
	//��ʼ���˵���
	protected MenuManager createMenuManager() {
		MenuManager top = new MenuManager();
		MenuManager fileMenu = new MenuManager("�ļ�(&F)");
		MenuManager editMenu = new MenuManager("�༭(&E)");
		MenuManager helpMenu = new MenuManager("����(&H)");
		
		fileMenu.add( new OpenAction(this) );
		fileMenu.add( new SaveAction(this) );
		fileMenu.add( new Separator());
		fileMenu.add( new PrintAction(this) );
		
		editMenu.add( new UndoAction(this));
		editMenu.add( new RedoAction(this));
		editMenu.add( new Separator());
		editMenu.add( new SearchAction(this));
		editMenu.add( new Separator());
		editMenu.add( new PreferenceAction(this));
		
		helpMenu.add( new HelpAction(this));
		top.add( fileMenu );
		top.add( editMenu ) ;
		top.add(helpMenu);
		
		return top;
	}
	//��ʼ��������
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBar = new ToolBarManager(style);
		toolBar.add(new OpenAction(this));
		toolBar.add( new SaveAction(this) );
		toolBar.add( new Separator());
		toolBar.add( new PrintAction(this) );
		
		toolBar.add( new UndoAction(this));
		toolBar.add( new RedoAction(this));
		toolBar.add( new Separator());
		toolBar.add( new SearchAction(this));
		toolBar.add( new Separator());
		toolBar.add( new PreferenceAction(this));
		toolBar.add( new HelpAction(this));
		return toolBar;
	}

	public PersistentDocument getDocument() {
		return document;
	}

	public SourceViewer getViewer() {
		return viewer;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public PreferenceStore getPreference() {
		return preference;
	}

	public void setPreference(PreferenceStore preference) {
		this.preference = preference;
	}

	public IUndoManager getUndoManager() {
		return undoManager;
	}

	public JSEditorConfiguration getConfiguration() {
		return configuration;
	}
	//ΪIPropertyChangeListener�ӿ��еķ�������������ѡ�������ʱ
	//�������ñ༭��������
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getNewValue()==null)
			return;
	    if (event.getProperty().equals(Constants.CODE_FONT))
	    	eventManager.setCodeFont( (FontData[]) event.getNewValue());
	}
}
