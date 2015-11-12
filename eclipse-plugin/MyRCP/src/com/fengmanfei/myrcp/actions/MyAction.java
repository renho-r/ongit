package com.fengmanfei.myrcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import com.fengmanfei.myrcp.editors.JsEditor;
import com.fengmanfei.myrcp.editors.JsEditorInput;

import myRCP.MyRCPPlugin;

public class MyAction extends Action implements ISelectionListener,IWorkbenchAction {
	private IWorkbenchWindow window;
	public final static String ID = " com.fengmanfei.myrcp.actions.MyAction";
	private IStructuredSelection selection;
	public MyAction(IWorkbenchWindow window) {
		super("Test Action");
		setId(ID);
		setText("My Action");
		setToolTipText("My Action");
		setImageDescriptor(MyRCPPlugin.getImageDescriptor("icons/sample.gif"));
		this.window = window;
		//ע��ѡ����������
		window.getSelectionService().addSelectionListener(this);
	}

	public void run() {
		String current = (String)selection.getFirstElement();
		IWorkbenchPage page = window.getActivePage();
		JsEditorInput editor = new JsEditorInput( current );
		try {
			page.openEditor( editor , JsEditor.ID );
		} catch (PartInitException e) {
			e.printStackTrace();
		}

	}
	//�ӿ�ISelectionListener�еķ���
	//���¼�����ʱ���ø÷���
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if (incoming instanceof IStructuredSelection) {
			//����¼�������Դ��Я���Ķ���
			selection = (IStructuredSelection) incoming;
			//ǿ��ת��
			String s = (String) selection.getFirstElement();
			Assert.isNotNull(s);
			//�����ѡ�е���"Three"��������Ϊ���ã���������Ϊ������
			if (s.equals("Three")) 
				setEnabled(true);
			else 
				setEnabled(false);
		}
	}
	//IWorkbenchAction�ӿ��еķ������ͷź�ȡ��ע��
	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

}
