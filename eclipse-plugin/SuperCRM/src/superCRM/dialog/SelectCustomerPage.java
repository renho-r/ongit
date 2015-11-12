package superCRM.dialog;

import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

import superCRM.model.ICustomerSerivce;
import superCRM.model.SuperFactory;
import superCRM.pojos.CustomerEO;
import superCRM.table.TableContentProvider;
import superCRM.table.TableLabelProvider;

public class SelectCustomerPage extends WizardPage {
	/** ҳ������ */
	public static final String SELECT_CUSTOMER_PAGE = "SELECT_CUSTOMER";

	/** �ͻ��б�ı��� */
	public static final String[] COLUMN_NAME = { "ID��", "�ͻ�����", "��ַ", "�ͻ����", "��˾����" };

	/** ��ѡ���ı�� */
	private CheckboxTableViewer viewer;

	/** ������� */
	public List data;

	/** �ͻ�������� */
	private ICustomerSerivce customerSerivce;

	/** �ͻ����� */
	private CustomerEO cusotmer;

	public SelectCustomerPage() {
		super(SELECT_CUSTOMER_PAGE, "�½��ͻ�", null);
		this.setTitle("ѡ��ͻ�");
		this.setDescription("��ѡ��ͻ�����ϸ��Ϣ��");
		this.setPageComplete(false);
		customerSerivce = SuperFactory.getSuperApplication().getCustomerSerivce();
		data = customerSerivce.getAllCustomers();
	}

	public void createControl(Composite parent) {
		/** ������岼�� */
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		/** ��ʼ�������� */
		viewer = CheckboxTableViewer.newCheckList(composite, SWT.FULL_SELECTION | SWT.SINGLE);
		for (int i = 0; i < COLUMN_NAME.length; i++) {
			new TableColumn(viewer.getTable(), SWT.LEFT).setText(COLUMN_NAME[i]);
			viewer.getTable().getColumn(i).pack();
		}
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		viewer.setContentProvider(new TableContentProvider());
		viewer.setLabelProvider(new TableLabelProvider());
		viewer.setInput(data);
		/** ע���񵥻������� */
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			/** �����������һ��ʱ */
			public void selectionChanged(SelectionChangedEvent event) {
				/** ��ñ��ѡ�е��� */
				Object[] checkedObj = viewer.getCheckedElements();
				/** �������ѡ����һ���ͻ�,����ʾ���� */
				if (checkedObj.length != 1) {
					setErrorMessage("��ѡ��һ���ͻ�");
					setPageComplete(false);
					return;
				}
				/** ������һ������״̬ */
				setErrorMessage(null);
				setPageComplete(true);
				/** ��ѡ�еĿͻ�����ֵ����ҳ��Ŀͻ����� */
				cusotmer = (CustomerEO) checkedObj[0];
			}

		});
		setControl(composite);
	}

	/** ��ø�ҳ��Ŀͻ����� */
	public CustomerEO getCusotmer() {
		return cusotmer;
	}

	/** ���ø�ҳ��Ŀͻ����� */
	public void setCusotmer(CustomerEO cusotmer) {
		this.cusotmer = cusotmer;
	}

}
