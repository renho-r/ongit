package j2setest.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(15555);
		Socket socket = null;
		socket = serverSocket.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
	}

}
