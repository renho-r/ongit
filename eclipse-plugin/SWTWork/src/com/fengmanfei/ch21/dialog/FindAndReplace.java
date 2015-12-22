package com.fengmanfei.ch21.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import com.fengmanfei.ch21.JSEditor;

public class FindAndReplace extends Dialog {

	private JSEditor editor;
	private Button btFind;//���Ұ�ť
	private Button btReplace;//�滻��ť
	private Button btFindAndReplace;//�������滻��ť
	private Button btClose;//�رհ�ť
	
	private FindReplaceDocumentAdapter findDdapater;
	public FindAndReplace(JSEditor editor ,Shell parentShell) {
		super(parentShell);
		this.editor = editor ;
		//�����ĵ��ַ�������������
		findDdapater = new FindReplaceDocumentAdapter(this.editor.getDocument());
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("����/�滻");
		newShell.setSize(200,270);
	}

	protected Control createContents(Composite parent) {
		//�����Ի���Ŀؼ�
		parent.setLayout(new GridLayout(2, false));
		new Label( parent , SWT.LEFT).setText("���ң�");
	    final Text findText = new Text(parent, SWT.BORDER);
	    findText.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    
		new Label( parent , SWT.LEFT).setText("�滻Ϊ��");
	    final Text replaceText = new Text(parent, SWT.BORDER);
	    replaceText.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    
	    Group group = new Group( parent, SWT.NONE);
	    GridData data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    group.setLayoutData(data);
	    group.setText("����");
	    group.setLayout(  new GridLayout(2,true) );
	    
	    final Button forwardButton = new Button(group,SWT.RADIO);
	    forwardButton.setText("ǰ��");
	    
	    final Button backButton = new Button(group,SWT.RADIO);
	    backButton.setText("����");
	    
	    group = new Group( parent, SWT.NONE);
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    group.setLayoutData(data);
	    group.setText("ѡ��");
	    group.setLayout(  new GridLayout(2,true) );
	    
	    final Button match = new Button(group,SWT.CHECK);
	    match.setText("���ִ�Сд");
	    
	    final Button wholeWord = new Button(group,SWT.CHECK);
	    wholeWord.setText("������");
	    
	    final Button regexp = new Button(group,SWT.CHECK);
	    regexp.setText("������ʽ");
	    
	    Composite composite = new Composite( parent , SWT.NONE);
	    data = new GridData(GridData.FILL_HORIZONTAL);
	    data.horizontalSpan = 2;
	    composite.setLayoutData(data);
	    composite.setLayout( new GridLayout(2,true));
	    
	    btFind = new Button( composite , SWT.PUSH );
	    btFind.setText("����");
	    btFind.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    
	    btReplace = new Button( composite , SWT.PUSH );
	    btReplace.setText("�滻");
	    btReplace.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    
	    btFindAndReplace = new Button( composite , SWT.PUSH );
	    btFindAndReplace.setText("����/�滻");
	    btFindAndReplace.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    
	    btClose = new Button( composite , SWT.PUSH );
	    btClose.setText("�رմ���");
	    btClose.setLayoutData( new GridData(GridData.FILL_HORIZONTAL));
	    //���ð�ť���¼�
	    //���ò���ѡ��ʱ��������ʽ��ƥ�������ַ�����ͬʱʹ��
	    wholeWord.addSelectionListener( new SelectionAdapter(){
	    	  public void widgetSelected(SelectionEvent event) {
	    		  if ( wholeWord.getSelection() ){
	    			  regexp.setSelection( false );
	    			  regexp.setEnabled( false );
	    		  }else{
	    			  regexp.setEnabled( true );
	    		  }
		        }
	    });
	    regexp.addSelectionListener( new SelectionAdapter(){
	    	  public void widgetSelected(SelectionEvent event) {
	    		  if ( regexp.getSelection() ){
	    			  wholeWord.setSelection( false );
	    			  wholeWord.setEnabled( false );
	    		  }else{
	    			  wholeWord.setEnabled( true );
	    		  }
		        }
	    });
	    //Ϊ���Ұ�ťע���¼�������
		btFind.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	          boolean b = editor.getEventManager().isFind( findDdapater,
	        		  findText.getText(),forwardButton.getSelection(),match.getSelection(),
	        		  wholeWord.getSelection(),regexp.getSelection());
	          //����ҵ�ƥ����ַ������滻���滻ȫ����ť����Ϊ����״̬
	          enableReplaceButtons(b);
	        }
	    });
		//Ϊ�滻��ťע���¼�������
		btReplace.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	          editor.getEventManager().doReplace( findDdapater , replaceText.getText());
	          enableReplaceButtons(false);
	        }
	    });
		//Ϊ����/��ťע���¼�������
		btFindAndReplace.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	          editor.getEventManager().doReplace( findDdapater , replaceText.getText());
	          boolean b = editor.getEventManager().isFind( findDdapater,
	        		  findText.getText(),forwardButton.getSelection(),match.getSelection(),
	        		  wholeWord.getSelection(),regexp.getSelection());
	          enableReplaceButtons(b);
	        }
	    });
		//Ϊ�رհ�ťע�������
		btClose.addSelectionListener(new SelectionAdapter() {
	        public void widgetSelected(SelectionEvent event) {
	        	getShell().close();
	        }
	    });
		//������ǰΪĬ��ѡ��״̬
		forwardButton.setSelection(true);
		//��ʼ��ʱ�滻�Ͳ����滻��ť������
	    enableReplaceButtons(false);
	    //���ý���Ϊ���ҵ��ı���
	    findText.setFocus();
		return parent;
	}

	private void enableReplaceButtons(boolean enable) {
		btReplace.setEnabled(enable);
		btFindAndReplace.setEnabled(enable);
	}
	
	
}