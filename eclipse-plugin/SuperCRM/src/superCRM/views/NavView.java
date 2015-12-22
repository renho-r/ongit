package superCRM.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import superCRM.SuperCRMPlugin;
import superCRM.action.ActionManager;

/** �����˵���ͼ */
public class NavView extends ViewPart {

	/** ������������ */
	private TreeViewer viewer;

	/** ����Ϊ����ӷ��ص����������� */
	private DrillDownAdapter drillDownAdapter;

	/** �۵������� */
	private Action collapseAction;

	/** չ�������� */
	private Action expandAction;

	/** ˫�������ʱ���� */
	private Action doubleClickAction;

	/** ����ͼ��ID */
	public static final String ID = "superCRM.views.NavView";

	/** ������� */
	class TreeObject implements IAdaptable {
		private String name;

		private String key;

		private TreeParent parent;

		public TreeObject(String name, String key) {
			this.name = name;
			this.key = key;
		}

		public String getName() {
			return name;
		}

		public void setParent(TreeParent parent) {
			this.parent = parent;
		}

		public TreeParent getParent() {
			return parent;
		}

		public String toString() {
			return getName();
		}

		public Object getAdapter(Class key) {
			return null;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
	}

	/** ���ĸ������ */
	class TreeParent extends TreeObject {
		private ArrayList children;

		public TreeParent(String name) {
			super(name, "__Parent");
			children = new ArrayList();
		}

		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}

		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}

		public TreeObject[] getChildren() {
			return (TreeObject[]) children.toArray(new TreeObject[children.size()]);
		}

		public boolean hasChildren() {
			return children.size() > 0;
		}
	}

	/** ���������� */
	class ViewContentProvider implements IStructuredContentProvider, ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot == null)
					initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}

		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject) child).getParent();
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent) parent).getChildren();
			}
			return new Object[0];
		}

		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent) parent).hasChildren();
			return false;
		}

		/** ��ʼ�����е����� */
		private void initialize() {

			TreeObject c1 = new TreeObject("�ͻ��б�", "CUSTOMER_LIST");
			TreeObject c2 = new TreeObject("��ӿͻ�", "CUSTOMER_ADD");
			TreeParent t1 = new TreeParent("�ͻ�����");
			t1.addChild(c1);
			t1.addChild(c2);

			TreeObject l1 = new TreeObject("��ϵ���б�", "CONTACT_LIST");
			TreeObject l2 = new TreeObject("�����ϵ��", "CONTACT_ADD");
			TreeParent t2 = new TreeParent("��ϵ�˹���");
			t2.addChild(l1);
			t2.addChild(l2);

			TreeObject p2 = new TreeObject("��ѡ������", "PREF");
			TreeParent t3 = new TreeParent("��������");
			t3.addChild(p2);

			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(t1);
			invisibleRoot.addChild(t2);
			invisibleRoot.addChild(t3);
		}
	}

	/** ���������� */
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}

	/** ���췽�� */
	public NavView() {
	}

	public void createPartControl(Composite parent) {
		/** ������ */
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		/** ��ʼ���� */
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(getViewSite());
		/** ����������ʹ�ò������� */
		makeActions();
		/** ��������Ĳ˵� */
		hookContextMenu();
		/** ���˫���¼� */
		hookDoubleClickAction();
		/** ��ӵ��������� */
		contributeToActionBars();
	}

	/** ��������Ĳ˵� */
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				NavView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/** ��ӵ��������� */
	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	/** ��������˵��� */
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(collapseAction);
		manager.add(new Separator());
		manager.add(expandAction);
	}

	/** ��������Ĳ˵��� */
	private void fillContextMenu(IMenuManager manager) {
		manager.add(collapseAction);
		manager.add(expandAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/** ��ӹ��������߰�ť */
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(collapseAction);
		manager.add(expandAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	/** ������ͼ��ʹ�õĲ������� */
	private void makeActions() {
		/** չ��ȫ����ť */
		collapseAction = new Action() {
			public void run() {
				viewer.collapseAll();
			}
		};
		collapseAction.setText("�۵�ȫ��");
		collapseAction.setToolTipText("�۵�ȫ��");
		collapseAction.setImageDescriptor(SuperCRMPlugin.getImageDescriptor("icons/collapse.gif"));
		/** �۵�ȫ����ť */
		expandAction = new Action() {
			public void run() {
				viewer.expandAll();
			}
		};
		expandAction.setText("չ��ȫ��");
		expandAction.setToolTipText("չ��ȫ��");
		expandAction.setImageDescriptor(SuperCRMPlugin.getImageDescriptor("icons/expand.gif"));
		/** ˫������ */
		doubleClickAction = new Action() {
			public void run() {
				/** ��õ�ǰѡ�е����ڵ� */
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				/** ���ѡ�е�ΪTreeParent����,�򷵻� */
				if (obj instanceof TreeParent)
					return;
				/** ���ѡ�е�Ϊ�ӽڵ�,�����keyֵ����Ӧ�Ĳ��� */
				TreeObject object = (TreeObject) obj;
				if (object.getKey().equals("CUSTOMER_LIST")) {
					ActionManager.createShowViewAction(getSite().getWorkbenchWindow(), CustomerSummaryView.ID).run();
				} else if (object.getKey().equals("CUSTOMER_ADD")) {
					ActionManager.createNewCustomerAction(getSite().getWorkbenchWindow()).run();
				} else if (object.getKey().equals("CONTACT_LIST")) {
					ActionManager.createShowViewAction(getSite().getWorkbenchWindow(), ContactSummaryView.ID).run();
				} else if (object.getKey().equals("CONTACT_ADD")) {
					ActionManager.createNewContactAction(getSite().getWorkbenchWindow()).run();
				} else if (object.getKey().equals("PREF")) {
					ActionFactory.PREFERENCES.create(getSite().getWorkbenchWindow()).run();
				}
			}
		};

	}

	/** ˫�����¼� */
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}
}