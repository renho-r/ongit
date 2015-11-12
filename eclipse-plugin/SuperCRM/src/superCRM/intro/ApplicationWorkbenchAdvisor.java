package superCRM.intro;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**��������*/
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	
	/**������Ĭ�ϵ�͸��ͼID*/
	private static final String PERSPECTIVE_ID = "SuperCRM.perspective";

	/**��������������*/
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    /**��ʼ������������*/
    public void initialize(IWorkbenchConfigurer configurer) {
        super.initialize(configurer);
        configurer.setSaveAndRestore(true);
    }
    
    /**���Ĭ��͸��ͼ��ID*/
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}
