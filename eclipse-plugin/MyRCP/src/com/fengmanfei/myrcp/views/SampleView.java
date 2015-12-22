package com.fengmanfei.myrcp.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.Assert;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.fengmanfei.myrcp.actions.MyAction;


public class SampleView extends ViewPart {
	//����ͼ��id,��plugin.xml�ļ��ж���,ͨ��ʹ���ַ��������ķ�ʽ
	public static final String ID = "com.fengmanfei.myrcp.views.SampleView";
	private TableViewer viewer;//��ͼ����ʾ�ı�����
	//��������
	private Action action1;
	private Action action2;
	//���췽��
	public SampleView() {
	}
	//Ϊ�����еĳ��󷽷���������ͼ�еĸ��ֿؼ�
	public void createPartControl(Composite parent) {
		//����һ��������
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();//������������
		hookDoubleClickAction();//��ӱ��˫���¼�
		hookContextMenu();//��������Ĳ˵�
		contributeToActionBars();//�����ͼ����������
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getTable(),"SampleViewContextId");
	}

	private void hookContextMenu() {
		//�����˵�����������
		MenuManager menuMgr = new MenuManager("#PopupMenu");	
		menuMgr.add(action1);
		menuMgr.add(action2);
		menuMgr.add(new MyAction( getSite().getWorkbenchWindow()));
		menuMgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		
		//Ϊ�б���󴴽������Ĳ˵�
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		//���ò˵�
		viewer.getControl().setMenu(menu);
		//ע�������Ĳ˵�
		getSite().registerContextMenu(menuMgr, viewer);
		getSite().setSelectionProvider(viewer); 
	}

	private void contributeToActionBars() {
		//�����ͼ�Ĳ���������
		IActionBars bars = getViewSite().getActionBars();
		//��������˵�
		fillLocalPullDown(bars.getMenuManager());
		//��ӹ�����
		fillLocalToolBar(bars.getToolBarManager());
	}
	//��������˵�
	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}
	
	//��ӹ�����
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
	}
	
	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	private void hookDoubleClickAction() {
		//ע��˫���¼�������
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			//��˫��ʱ
			public void doubleClick(DoubleClickEvent event) {
				//��õ�ǰѡ�е�һ��
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				//���Ҫ��ʾ���ݵ���ͼ����
				IViewPart viewPart =  getSite().getPage().findView(AnotherView.ID);
				//ȷ���ҵ���Ҫʹ�õ���ͼ
				Assert.isNotNull(viewPart);
				//ǿ������ת��Ϊ��һ����ͼ����
				AnotherView view = (AnotherView)viewPart;
				//���ø���ͼ����ʾ������
				view.setContent( "��˫����"+(String)obj );
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"������ͼ",
			message);
	}
	//�����еĳ��󷽷�������ͼ��ý���ʱ������������Ϊ���
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			return new String[] { "One", "Two", "Three" };
		}
	}
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}
}