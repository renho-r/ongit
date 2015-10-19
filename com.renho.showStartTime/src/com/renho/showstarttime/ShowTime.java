package com.renho.showstarttime;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;

public class ShowTime implements IStartup {
	public void earlyStartup() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				long eclipseStartTime = Long.parseLong(System.getProperty("eclipse.startTime"));
				long costTime = System.currentTimeMillis() - eclipseStartTime;
				Shell shell = Display.getDefault().getActiveShell();
				String message = "Eclipse start in " + costTime + "ms";
				MessageDialog.openInformation(shell, "Information", message);
			}
		});
	}
}