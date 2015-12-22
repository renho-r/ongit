package superCRM.views;

import java.util.List;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import superCRM.model.IContactSerivce;
import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.CustomerEO;
import superCRM.table.TableContentProvider;
import superCRM.table.TableLabelProvider;

public class ContactSummaryView extends ViewPart implements ISelectionListener {
	/** ����ͼ��ID */
	public static final String ID = "superCRM.views.ContactSummaryView";

	/** ��ͷ���� */
	public static final String[] COLUMN_NAME = { "ID��", "����", "�ͻ�����", "���", "�Ա�", "��������", "ְλ" };

	/** ��ǰѡ�еĶ��� */
	private IStructuredSelection currentSelection;

	/** ��ϵ�����������Ŀͻ� */
	private CustomerEO customer;

	/** ��ϵ�����ݶ��� */
	public List data;

	/** ��ϵ�˱���� */
	private TableViewer viewer;

	/** �ͻ����� */
	private ICustomerSerivce customerSerivce;

	/** ��ϵ�˷��� */
	private IContactSerivce contactSerivce;

	public ContactSummaryView() {
		super();
		/** �����ͻ�����ϵ�˷������ */
		customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
		contactSerivce = SuperFactory.getSuperApplication().getContactSerivce();
	}

	public void createPartControl(Composite parent) {
		/** ע��ѡ�������� */
		this.getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
		/** ��ʼ����ϵ�˱�� */
		viewer = new TableViewer(parent, SWT.FULL_SELECTION);
		for (int i = 0; i < COLUMN_NAME.length; i++) {
			new TableColumn(viewer.getTable(), SWT.LEFT).setText(COLUMN_NAME[i]);
			viewer.getTable().getColumn(i).pack();
		}
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		/** Ĭ�������������ʾ������ϵ�� */
		data = contactSerivce.getAllContacts();
		viewer.setInput(data);
	}

	public void setFocus() {
		viewer.getTable().setFocus();
	}

	/** �������ͻ���¼ʱ */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (selection instanceof IStructuredSelection) {
			/** ��õ�ǰѡ�еĿͻ����� */
			currentSelection = (IStructuredSelection) selection;
			if (currentSelection.getFirstElement() instanceof CustomerEO) {
				customer = (CustomerEO) currentSelection.getFirstElement();
				/** ����������ϵ���б��е����� */
				this.setData(customerSerivce.getContacts(customer));
			}
		}
	}

	public void dispose() {
		super.dispose();
		this.getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
	}

	/** �������� */
	public void setData(List data) {
		this.data = data;
		viewer.setInput(this.data);
		viewer.refresh();
	}

	/** �������� */
	public void refreshData() {
		data = contactSerivce.getAllContacts();
		viewer.setInput(data);
		viewer.refresh();
	}

}
