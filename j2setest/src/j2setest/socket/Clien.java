package j2setest.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clien {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1", 15555);
	}

}
