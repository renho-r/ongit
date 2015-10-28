package com.renho;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class ReceiveThread implements Runnable {

	private Socket socket;
	private Text receiveText;

	public ReceiveThread(Socket socket, Text receiveText) {
		this.socket = socket;
		this.receiveText = receiveText;
	}

	@Override
	public void run() {
		while (true) {
			InputStream in;
			StringBuilder receiveMsg = new StringBuilder();
			try {
				in = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int readCount = in.read(bytes);
				while (-1 != readCount) {
					String temp = new String(bytes, 0, readCount);
					receiveMsg.append(temp);
					if(1024 == readCount) {
						readCount = in.read(bytes);						
					}else {
						readCount = -1;
						receiveMsg.append("\n");
					}
				}
				Display.getDefault().syncExec(new Runnable() {
					@Override
					public void run() {
						receiveText.append(receiveMsg.toString());
					}
				});
			} catch (IOException e) {
				System.out.println("client catch exception");
				e.printStackTrace();
				break;
			}
		}
	}

}