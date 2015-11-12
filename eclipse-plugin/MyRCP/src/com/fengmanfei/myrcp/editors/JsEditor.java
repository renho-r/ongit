package com.fengmanfei.myrcp.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class JsEditor extends EditorPart {
	//��Ӧplugin.xmlָ����id
	public static final String ID = "com.fengmanfei.myrcp.editors.JsEditor";
	private Text text;
	//�༭���е������Ƿ��޸ĵı�־
	private boolean bDirty = false;
	public JsEditor() {
		super();
	}
	//��ʼ���༭��
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		this.setSite(site);//����site
		this.setInput(input);//���������IEditorInput����
		this.setPartName(input.getName());//���ñ༭���Ϸ���ʾ������
	}
	//�����༭���еĿؼ�
	public void createPartControl(Composite parent) {
		text = new Text(parent, SWT.NONE);
		//���ı����޸�ʱ���趨���ݱ��޸Ĺ�
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (!isDirty()) {//���δ�޸�
					setDirty(true);//�����޸�
					//���ı༭����״̬
					firePropertyChange(IEditorPart.PROP_DIRTY);
				}
			}
		});
	}
	//�༭���ر�ʱ������༭������ʱ�����õķ���
	public void doSave(IProgressMonitor monitor) {
		//������״̬��ʾ��״̬����
		try {
			monitor.beginTask("�����ļ�...", 100);

			for (int i = 0; i < 10 && !monitor.isCanceled(); i++) {
				Thread.sleep(500);
				monitor.worked(10);
				double d = (i + 1) / 10d;
				monitor.subTask("�����" + d * 100 + "%");// ��ʾ����״̬
			}
			monitor.done();
			if (monitor.isCanceled())
				throw new InterruptedException("ȡ������");
		} catch (InterruptedException e) {
			;
		}
	}
	//���Ϊ���õķ���
	public void doSaveAs() {

	}
	//�ж��Ƿ��޸Ĺ�
	public boolean isDirty() {
		return bDirty;
	}
	//�Ƿ�������
	public boolean isSaveAsAllowed() {
		return true;
	}
	//���ý���
	public void setFocus() {
		text.setFocus();
	}
	//���ñ༭�����ݱ��޸Ĺ�
	public void setDirty(boolean b) {
		bDirty = b;
	}
	
}
