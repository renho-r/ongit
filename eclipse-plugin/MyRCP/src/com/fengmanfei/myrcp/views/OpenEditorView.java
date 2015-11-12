package com.fengmanfei.myrcp.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.ViewPart;

import com.fengmanfei.myrcp.editors.JsEditor;
import com.fengmanfei.myrcp.editors.JsEditorInput;
import com.fengmanfei.myrcp.editors.MutiEditorSample;
import com.fengmanfei.myrcp.forms.MyMutiForm;

public class OpenEditorView extends ViewPart {
	public static final String ID = "com.fengmanfei.myrcp.views.OpenEditorView";

	public List list;

	public OpenEditorView() {
		super();
	}

	public void createPartControl(Composite parent) {
		list = new List(parent, SWT.NONE);
		list.add("Editor");
		list.add("MutiPage Editor");
		list.add("Form Editor");
		list.add("Master/Detail Page");
		list.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				String select = list.getSelection()[0];
				// ��õ�ǰ�����IWorkbenchPage����
				IWorkbenchPage page = getViewSite().getWorkbenchWindow().getActivePage();
				try {
					if (select.equals("Editor")) {// ���ѡ�е�"Editor"һ��
						// ������������ݶ���
						JsEditorInput editor = new JsEditorInput(select);
						// �򿪸ñ༭��
						page.openEditor(editor, JsEditor.ID);

					} else if (select.equals("MutiPage Editor")) {// ���ѡ�е�"Editor"һ��
						page.openEditor(new NullEditorInput(), MutiEditorSample.ID);

					}else if (select.equals("Form Editor")) {// ���ѡ�е�"Editor"һ��
							page.openEditor(new NullEditorInput(), MyMutiForm.ID);
					}
				} catch (PartInitException ee) {
					ee.printStackTrace();
				}
				
			}

		});
	}

	public void setFocus() {
		list.setFocus();
	}
}
