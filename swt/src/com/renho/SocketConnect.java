package com.renho;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SocketConnect {

	private Text ipText;
	private Text portText;
	private Socket socket;
	private Text sendText;
	private Text receiveText;
	private Display display;

	public SocketConnect() {

	}

	public void show() {
		display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Socket Connect");
		shell.setBounds(200, 200, 600, 500);
		shell.setLayout(new FillLayout());
		addComposite(shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.beep();
		display.dispose();
		if(null != socket) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

	public void addComposite(Shell shell) {

		Group group = new Group(shell, SWT.NONE);
		group.setText("Test Connect");
		GridLayout layout = new GridLayout();
		layout.numColumns = 6;
		layout.marginWidth = 30;
		layout.marginHeight = 10;
		group.setLayout(layout);
		group.setLayoutData(new GridData(SWT.FILL));
		
		Group groupTop = new Group(group, SWT.NONE);
		groupTop.setText("IP/PORT");
		GridLayout layoutTop = new GridLayout();
		layoutTop.numColumns = 6;
		layoutTop.marginWidth = 0;
		layoutTop.marginHeight = 0;
		groupTop.setLayout(layoutTop);
		groupTop.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 6, 1));

		Label usernameLabel = new Label(groupTop, SWT.NONE);
		usernameLabel.setText("ip:");

		ipText = new Text(groupTop, SWT.BORDER);
		ipText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		ipText.setText("127.0.0.1");

		Label passwordLabel = new Label(groupTop, SWT.NONE);
		passwordLabel.setText("port:");

		portText = new Text(groupTop, SWT.BORDER);
		portText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		portText.setText("8080");

		Button connectBtn = new Button(groupTop, SWT.PUSH);
		connectBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		connectBtn.setText("连接");
		connectBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {

				if (null == socket) {
					String ip = ipText.getText();
					String port = portText.getText();

					try {
						socket = new Socket(ip, Integer.valueOf(port));
						Thread thread = new Thread(new ReceiveThread(socket, receiveText));
						thread.start();
						OutputStream out = socket.getOutputStream();
						out.write("renho".getBytes());
						out.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Button closeBtn = new Button(groupTop, SWT.PUSH);
		closeBtn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		closeBtn.setText("关闭");
		closeBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {

				if (null != socket) {
					try {
						socket.close();
						socket = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Group groupCenter = new Group(group, SWT.NONE);
		groupCenter.setText("send receive");
		GridLayout layoutCenter = new GridLayout();
		layoutCenter.numColumns = 4;
		layoutCenter.marginWidth = 0;
		layoutCenter.marginHeight = 0;
		groupCenter.setLayout(layoutCenter);
		groupCenter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 6, 1));

		Label sendLabel = new Label(groupCenter, SWT.NONE);
		sendLabel.setText("发送:");

		sendText = new Text(groupCenter, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData sendLabelText = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		sendLabelText.heightHint = 232;
		sendText.setLayoutData(sendLabelText);

		Label receiveLabel = new Label(groupCenter, SWT.NONE);
		receiveLabel.setText("接收");
		GridData receiveLabelText = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		receiveLabelText.heightHint = 232;
		receiveText = new Text(groupCenter, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
		receiveText.setLayoutData(receiveLabelText);
		
		new Label(groupCenter, SWT.NONE);
		Button sendBtn = new Button(groupCenter, SWT.PUSH);
		sendBtn.setText("发送:");
		sendBtn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		sendBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				String sendStr = sendText.getText();
				if (null != socket) {
					OutputStream out;
					try {
						out = socket.getOutputStream();
						out.write(sendStr.getBytes());
						out.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		

	}

	public static void main(String[] args) {
		SocketConnect socketConnect = new SocketConnect();
		socketConnect.show();
	}
}
