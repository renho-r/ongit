package superCRM.views;

import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import superCRM.editor.CustomerDetailEditor;
import superCRM.editor.CustomerDetailInput;
import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.CustomerEO;
import superCRM.table.TableContentProvider;
import superCRM.table.TableLabelProvider;

public class CustomerSummaryView extends ViewPart {
	/** ����ͼ��ID */
	public static final String ID = "superCRM.views.CustomerSummaryView";

	/** ��ͷ���� */
	public static final String[] COLUMN_NAME = { "ID��", "�ͻ�����", "��ַ", "�ͻ����", "��˾����" };

	/** ���е����� */
	public List data;

	/** ����� */
	private TableViewer viewer;

	/** �ͻ�������� */
	private ICustomerSerivce customerSerivce;

	/** �ͻ���ϸ�༭��������� */
	private CustomerDetailInput customerDetailInput;

	public CustomerSummaryView() {
		super();
		/** ��ÿͻ�������� */
		customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
		/** ��ѯ���еĿͻ����� */
		data = customerSerivce.getAllCustomers();
	}

	/** ������ͼ�Ľ��� */
	public void createPartControl(Composite parent) {
		/** ��ʼ����� */
		viewer = new TableViewer(parent, SWT.FULL_SELECTION);
		for (int i = 0; i < COLUMN_NAME.length; i++) {
			new TableColumn(viewer.getTable(), SWT.LEFT).setText(COLUMN_NAME[i]);
			viewer.getTable().getColumn(i).pack();
		}
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		/** ���ñ��������� */
		viewer.setContentProvider(new TableContentProvider());
		/** ���ñ��ı�ǩ�� */
		viewer.setLabelProvider(new TableLabelProvider());
		/** ���ñ������� */
		viewer.setInput(data);
		/** ��˫�����ʱ */
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				/** �򿪿ͻ���ϸ�༭�� */
				StructuredSelection select = (StructuredSelection) event.getSelection();
				/** ��õ�ǰѡ�еĿͻ� */
				CustomerEO c = (CustomerEO) select.getFirstElement();
				/** �����ͻ���ϸ�༭��������� */
				customerDetailInput = new CustomerDetailInput(c);
				/** �򿪿ͻ���ϸ�༭�� */
				IWorkbenchPage page = getViewSite().getWorkbenchWindow().getActivePage();
				try {
					page.openEditor(customerDetailInput, CustomerDetailEditor.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}

		});
		/** ���ñ��ע��Ϊѡ������ṩ�� */
		this.getSite().setSelectionProvider(viewer);

	}

	public void setFocus() {
		viewer.getTable().setFocus();
	}

	public List getData() {
		return data;
	}

	/** ���ñ������ */
	public void setData(List data) {
		this.data = data;
		viewer.setInput(this.data);
		viewer.refresh();
	}

	/** ˢ�±������ */
	public void refreshData() {
		data = customerSerivce.getAllCustomers();
		viewer.setInput(data);
		viewer.refresh();
	}

}
