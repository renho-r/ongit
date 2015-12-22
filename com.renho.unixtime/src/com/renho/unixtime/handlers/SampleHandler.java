package com.renho.unixtime.handlers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		/*MessageDialog.openInformation(
				window.getShell(),
				"Unixtime",
				"Hello, Eclipse world");*/
		InputDialog inputDialog = new InputDialog(window.getShell(), "Unixtime", "Hello, Eclipse world", "1", null);
		inputDialog.open();
		String value = inputDialog.getValue();
		Date date = new Date(Long.valueOf(value));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String s = sdf.format(date);
		
		MessageDialog.openInformation(
				window.getShell(),
				"Unixtime",
				s);
		return null;
	}
}
